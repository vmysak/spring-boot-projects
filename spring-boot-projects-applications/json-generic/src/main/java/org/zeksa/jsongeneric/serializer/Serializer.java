package org.zeksa.jsongeneric.serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.zeksa.jsongeneric.container.ChangeTypeListContainer;
import org.zeksa.jsongeneric.container.EnumsListContainer;
import org.zeksa.jsongeneric.intefaces.JSONCompatible;

public class Serializer {

    private static Gson gson;

    static {
        gson = new GsonBuilder()
                .registerTypeAdapter(ChangeTypeListContainer.class, new ChangeTypeListContainerSerializer())
                .registerTypeAdapter(EnumsListContainer.class, new EnumsListContainerSerializer())
                .create();
    }

    private Serializer() {
    }

    public static <T extends JSONCompatible> String serialize(T data) {
        return gson.toJson(data);
    }

    public static ChangeTypeListContainer deserializeChangeTypeListContainer(String data) {
        return gson.fromJson(data, ChangeTypeListContainer.class);
    }

    public static EnumsListContainer deserializeEnumsListContainer(String data) {
        return gson.fromJson(data, EnumsListContainer.class);
    }

}
