package com.store.application.controllers;

import com.store.application.models.SelectorFurnitureTransaction;
import com.store.application.models.entity.Furniture;

public class SelectorFurnitureController {
    private final SelectorFurnitureTransaction selector;

    public SelectorFurnitureController(SelectorFurnitureTransaction selector) {
        this.selector = selector;
    }

    public Furniture select(Class<? extends Furniture> furnitureClass , int index){
        return selector.select(furnitureClass, index);
    }
}
