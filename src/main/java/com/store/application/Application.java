package com.store.application;

import com.store.application.controllers.RegisterFurnitureController;
import com.store.application.models.RegisterFurnitureTransaction;
import com.store.application.utils.files.FileManagement;
import com.store.application.utils.files.Serializer;
import com.store.application.utils.generators.FurnitureGenerator;

public class Application {
    public void run(){
        RegisterFurnitureController registerFurnitureController = new RegisterFurnitureController(
                new RegisterFurnitureTransaction(new Serializer<>(), new FileManagement())
        );
        for (int i = 0; i < 10; i++) {
            registerFurnitureController.register(FurnitureGenerator.getInstance().generateTrad());
        }
        for (int i = 0; i < 8; i++) {
            registerFurnitureController.register(FurnitureGenerator.getInstance().generatePers());
        }
    }
}
