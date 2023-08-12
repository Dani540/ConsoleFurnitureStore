package com.store.application.utils.generators;;

import java.util.Random;
import java.util.stream.IntStream;

public class PasswordGenerator {
    private static PasswordGenerator passwordGenerator;
    public String generate(){
        int limit = new Random().nextInt(10,15);
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(1, limit)
                .forEach(i ->{
                    int c = new Random().nextInt(65,90);
                    stringBuilder.append ( (char)c );
                });
        return stringBuilder.toString();
    }

    public static PasswordGenerator getInstance() {
        if (passwordGenerator==null) passwordGenerator = new PasswordGenerator();
        return passwordGenerator;
    }
}
