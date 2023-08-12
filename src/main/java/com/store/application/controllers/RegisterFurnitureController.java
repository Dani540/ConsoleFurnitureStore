package com.store.application.controllers;

import com.store.application.models.entity.Furniture;
import com.store.application.models.RegisterFurnitureTransaction;

public class RegisterFurnitureController {
    private final RegisterFurnitureTransaction registerTransaction;

    public RegisterFurnitureController(RegisterFurnitureTransaction registerTransaction) {
        this.registerTransaction = registerTransaction;
    }

    public boolean register(Furniture furniture){
        return furniture != null && registerTransaction.register(furniture);
    }
}
