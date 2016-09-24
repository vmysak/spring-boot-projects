package org.zeksa.jsongeneric.serializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;
import org.zeksa.jsongeneric.model.ListOf;
import org.zeksa.jsongeneric.util.FieldName;

import java.lang.reflect.Type;

class ListOfSerializer implements JsonSerializer<ListOf>, JsonDeserializer<ListOf> {

    @Override
    public JsonElement serialize(ListOf listOf, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        String name = listOf.getName();

        jsonObject.add(name, DefaultSerializer.toJsonTree((listOf.getList())));

        return jsonObject;
    }

    @Override
    public ListOf deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = (JsonObject) jsonElement;

        for(FieldName fieldName:FieldName.values()){
            String name=fieldName.getName();
            if(jsonObject.has(name)){

                break;
            }
        }
        return DefaultSerializer.fromJsonTree(jsonElement, type);
    }
}
