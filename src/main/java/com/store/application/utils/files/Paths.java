package com.store.application.utils.files;

public enum Paths {
    furniture("data/furniture"),
    traditional(furniture.path + "/traditionals.txt"),
    personalized(furniture.path + "/personalized.txt"),
    tickets("data/tickets"),
    clients("data/clients");
    private final String path;

    Paths(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
