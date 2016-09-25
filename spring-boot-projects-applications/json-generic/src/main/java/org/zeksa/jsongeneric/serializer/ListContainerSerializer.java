package org.zeksa.jsongeneric.serializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.zeksa.jsongeneric.container.ObjectListContainer;
import org.zeksa.jsongeneric.util.DataTypeMapping;
import org.zeksa.jsongeneric.util.ListName;

import java.lang.reflect.Type;

class ListContainerSerializer implements JsonSerializer<ObjectListContainer>, JsonDeserializer<ObjectListContainer> {

    @Override
    public JsonElement serialize(ObjectListContainer objectListContainer, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        String name = objectListContainer.getListName().getName();

        jsonObject.add(ListName.DATA_TYPE.getName(), DefaultSerializer.toJsonTree(objectListContainer.getDataType()));
        jsonObject.add(name, DefaultSerializer.toJsonTree(objectListContainer.getList()));

        return jsonObject;
    }

    @Override
    public ObjectListContainer deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject= (JsonObject) jsonElement;
        String dataType=jsonObject.get(ListName.DATA_TYPE.getName()).getAsString();
        Class dataClass= DataTypeMapping.getMappedClass(dataType);
        System.out.println(dataClass);
                
        return null;
    }
}
