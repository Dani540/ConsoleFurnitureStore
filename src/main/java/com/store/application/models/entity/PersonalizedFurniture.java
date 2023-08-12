package com.store.application.models.entity;

public class PersonalizedFurniture extends Furniture{
    private final boolean requireBuild;
    private final Client client;

    public PersonalizedFurniture(String name, String description, double weight, double price, boolean requireBuild, Client client) {
        super(name, description, weight, price);
        this.requireBuild = requireBuild;
        this.client = client;
    }
}
