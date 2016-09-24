package org.zeksa.jsongeneric.serializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.zeksa.jsongeneric.model.ListContainer;
import org.zeksa.jsongeneric.util.FieldName;

import java.lang.reflect.Type;

class DataContainerSerializer implements JsonSerializer<ListContainer>, JsonDeserializer<ListContainer> {

    @Override
    public JsonElement serialize(ListContainer listContainer, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        String name = listContainer.getList().getName();

        jsonObject.add(FieldName.DATA_TYPE.getName(), DefaultSerializer.toJsonTree(listContainer.getDataType()));
        jsonObject.add(name, DefaultSerializer.toJsonTree(listContainer.getList().getList()));

        return jsonObject;
    }

    @Override
    public ListContainer deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return null;
    }
}
