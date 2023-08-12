package com.store.application.utils.files;

import com.google.gson.Gson;

public class Serializer<T> implements ISerializer<T>{
    public String serialize(T entity){
        Gson gSon = new Gson();
        return gSon.toJson(entity);
    }

    public T deserialize(String json, Class<? extends T> clazz){
        Gson gson = new Gson();
        return gson.fromJson(json, clazz);
    }
}
