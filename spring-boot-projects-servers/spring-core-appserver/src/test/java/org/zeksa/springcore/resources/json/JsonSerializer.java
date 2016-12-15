package org.zeksa.springcore.resources.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import java.lang.reflect.Type;

public class JsonSerializer {

    private static Gson gson;

    static {
        gson = new GsonBuilder().create();
    }

    private JsonSerializer() {
    }

    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    public static JsonElement toJsonTree(Object obj) {
        return gson.toJsonTree(obj);
    }

    public static <T> T fromJsonTree(JsonElement jsonElement, Type type) {
        return gson.fromJson(jsonElement, type);
    }
}
