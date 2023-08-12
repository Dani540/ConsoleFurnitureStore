package com.store.application.utils.files;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManagement implements IFileManagement {

    @Override
    public boolean createFile(String path) {
        String dir = getDir(path);
        if (!isDirExist(dir)) createDir(dir);
        try {
            File file = new File(path);
            return file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getDir(String path) {
        List<String> words = new ArrayList<>(List.of(path.split("/")));
        words.remove(words.size()-1);
        return String.join("/",words);
    }

    @Override
    public boolean createDir(String path) {
        File directory = new File(path);
        return directory.mkdirs();
    }

    @Override
    public boolean deleteFile(String path) {
        File file = new File(path);
        return file.exists() && file.isFile() && file.delete();
    }

    @Override
    public boolean deleteDir(String path) {
        File directory = new File(path);
        return directory.exists() && directory.isDirectory() && deleteDirectory(directory);
    }

    private boolean deleteDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteDirectory(file);
                } else {
                    file.delete();
                }
            }
        }
        return directory.delete();
    }

    @Override
    public boolean isFileExist(String path) {
        File file = new File(path);
        return file.exists() && file.isFile();
    }

    @Override
    public boolean isDirExist(String path) {
        File directory = new File(path);
        return directory.exists() && directory.isDirectory();
    }

    @Override
    public String readFile(String path) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content.toString();
    }

    @Override
    public String readLine(String path, int line) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String currentLine;
            int currentLineNumber = 0;
            while ((currentLine = reader.readLine()) != null) {
                currentLineNumber++;
                if (currentLineNumber == line) {
                    return currentLine;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<String> readAllLines(String path) {
        return readAllLines(path, 0);
    }

    @Override
    public boolean writeLine(String path, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.write(content);
            writer.newLine();
            return true;
        }catch (FileNotFoundException e){
            createDir( getDir(path) );
            writeLine(path, content);
            return true;
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> readAllLines(String path, int bound) {
        return readAllLines(path, 1, bound);
    }

    @Override
    public List<String> readAllLines(String path, int start, int bound) {
        List<String> lines = new ArrayList<>();
        if (isFileExist(path) && start > 0 && bound >= start) {
            try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                String line;
                int currentLineNumber = 0;
                while ((line = reader.readLine()) != null) {
                    currentLineNumber++;
                    if (currentLineNumber >= start && currentLineNumber <= bound) {
                        lines.add(line);
                    }
                    if (currentLineNumber > bound) {
                        break; // Detener la lectura cuando se alcance el límite superior
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return lines;
    }
}
