package org.zeksa.jsongeneric.lib.serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import java.lang.reflect.Type;

class DefaultSerializer {

    private static Gson gson;

    static {
        gson = new GsonBuilder().create();
    }

    private DefaultSerializer() {
    }

    public static JsonElement toJsonTree(Object obj) {
        return gson.toJsonTree(obj);
    }

    public static <T> T fromJsonTree(JsonElement jsonElement, Type type) {
        return gson.fromJson(jsonElement, type);
    }

}