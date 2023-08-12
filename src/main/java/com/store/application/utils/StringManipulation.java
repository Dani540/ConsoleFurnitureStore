package com.store.application.utils;

public class StringManipulation {
    public static String toSnake(String str) {
        return str.replaceAll("\\s", "_");
    }

    public static String revertSnake(String str) {
        return str.replaceAll("_", " ");
    }
}
