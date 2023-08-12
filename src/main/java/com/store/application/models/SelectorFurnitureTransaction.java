package com.store.application.models;

import com.store.application.models.entity.Furniture;
import com.store.application.models.entity.TraditionalFurniture;
import com.store.application.utils.files.IFileManagement;
import com.store.application.utils.files.ISerializer;
import com.store.application.utils.files.Paths;

public class SelectorFurnitureTransaction {
    private final IFileManagement fileManagement;
    private final ISerializer<Furniture> serializer;

    public SelectorFurnitureTransaction(IFileManagement fileManagement, ISerializer<Furniture> serializer) {
        this.fileManagement = fileManagement;
        this.serializer = serializer;
    }

    public Furniture select(Class<? extends Furniture> furnitureClass, int index) {
        String respectivePath = furnitureClass.equals(TraditionalFurniture.class)
                ? Paths.traditional.getPath() : Paths.personalized.getPath();
        return serializer.deserialize(
                fileManagement.readLine(respectivePath, index),
                furnitureClass
        );
    }
}
