package org.zeksa.jsongeneric.lib.serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.zeksa.jsongeneric.lib.container.ObjectListContainer;
import org.zeksa.jsongeneric.lib.container.ObjectMapContainer;
import org.zeksa.jsongeneric.lib.intefaces.JSONCompatible;
import org.zeksa.jsongeneric.lib.intefaces.JsonClassMapping;

public class Serializer {

    private static Gson gson = null;
    private static Serializer instance;

    private Serializer() {
    }

    private Serializer(JsonClassMapping mapping) {
        gson = new GsonBuilder()
                .registerTypeAdapter(ObjectListContainer.class, new ObjectListContainerSerializer(mapping))
                .create();
    }

    public static synchronized Serializer getInstance(JsonClassMapping mapping) {
        if (instance == null) {
            instance = new Serializer(mapping);
        }
        return instance;
    }

    public <T extends JSONCompatible> String serialize(T data) {
        return gson.toJson(data);
    }

    public ObjectMapContainer deserializeMap(String data) {
        return gson.fromJson(data, ObjectMapContainer.class);
    }

    public ObjectListContainer deserializeList(String data) {
        return gson.fromJson(data, ObjectListContainer.class);
    }

}
