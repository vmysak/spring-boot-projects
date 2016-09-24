package org.zeksa.jsongeneric.serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.zeksa.jsongeneric.model.ListContainer;
import org.zeksa.jsongeneric.model.JSONCompatible;
import org.zeksa.jsongeneric.model.ListOf;

public class Serializer {

    private static Gson gson;

    static {
        gson = new GsonBuilder()
                .registerTypeAdapter(ListOf.class, new ListOfSerializer())
                .registerTypeAdapter(ListContainer.class, new DataContainerSerializer())
                .create();
    }

    private Serializer() {
    }

    public static <T extends JSONCompatible> String serialize(T data) {
        return gson.toJson(data);
    }

    public static ListOf deserializeListOf(String data) {
        return gson.fromJson(data, ListOf.class);
    }

}
