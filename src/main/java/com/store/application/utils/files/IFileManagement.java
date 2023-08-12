package com.store.application.utils.files;

import java.util.List;

public interface IFileManagement {
    boolean createFile(String path);
    boolean createDir(String path);
    boolean deleteFile(String path);
    boolean deleteDir(String path);
    boolean isFileExist(String path);
    boolean isDirExist(String path);
    String readFile(String path);
    String readLine(String path, int line);
    List<String> readAllLines(String path);
    List<String> readAllLines(String path, int bound);
    List<String> readAllLines(String path, int start, int bound);
    boolean writeLine(String path, String content);
}
