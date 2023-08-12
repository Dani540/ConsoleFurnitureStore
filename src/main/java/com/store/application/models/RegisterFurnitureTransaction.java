package com.store.application.models;

import com.store.application.models.entity.Furniture;
import com.store.application.models.entity.TraditionalFurniture;
import com.store.application.utils.files.IFileManagement;
import com.store.application.utils.files.ISerializer;
import com.store.application.utils.files.Paths;

public class RegisterFurnitureTransaction {
    private final ISerializer<Furniture> serializer;
    private final IFileManagement fileManagement;

    public RegisterFurnitureTransaction(ISerializer<Furniture> serializer, IFileManagement fileManagement) {
        this.serializer = serializer;
        this.fileManagement = fileManagement;
    }

    public boolean register(Furniture entity) {
        String respectivePath = entity instanceof TraditionalFurniture
                ? Paths.traditional.getPath() : Paths.personalized.getPath();
        fileManagement.createDir(Paths.furniture.getPath());
        return fileManagement.writeLine(respectivePath, serializer.serialize(entity) );
    }
}
