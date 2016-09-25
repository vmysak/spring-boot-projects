package org.zeksa.jsongeneric.serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.zeksa.jsongeneric.container.ObjectListContainer;
import org.zeksa.jsongeneric.intefaces.JSONCompatible;

public class Serializer {

    private static Gson gson;

    static {
        gson = new GsonBuilder()
                .registerTypeAdapter(ObjectListContainer.class, new ListContainerSerializer())
                .create();
    }

    private Serializer() {
    }

    public static <T extends JSONCompatible> String serialize(T data) {
        return gson.toJson(data);
    }

    public static ObjectListContainer deserializeListContainer(String data) {
        return gson.fromJson(data, ObjectListContainer.class);
    }

}
