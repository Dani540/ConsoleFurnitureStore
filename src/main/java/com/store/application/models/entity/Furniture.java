package com.store.application.models.entity;

import com.store.application.utils.StringManipulation;
import lombok.ToString;

@ToString
public class Furniture {
    private final String name, description;
    private final double weight, price;

    public Furniture(String name, String description, double weight, double price) {
        this.name = StringManipulation.toSnake(name);
        this.description = StringManipulation.toSnake(description);
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return StringManipulation.revertSnake(name);
    }

    public String getDescription() {
        return StringManipulation.revertSnake(description);
    }
}
