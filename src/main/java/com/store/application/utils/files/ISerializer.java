package com.store.application.utils.files;

public interface ISerializer<Entity> {
    String serialize(Entity entity);
    Entity deserialize(String json, Class<? extends Entity> clazz);
}
