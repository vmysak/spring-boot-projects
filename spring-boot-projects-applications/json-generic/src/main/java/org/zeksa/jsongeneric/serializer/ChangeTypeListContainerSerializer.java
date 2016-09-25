package org.zeksa.jsongeneric.serializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.zeksa.jsongeneric.container.ChangeTypeListContainer;
import org.zeksa.jsongeneric.util.ChangeTypeMapping;
import org.zeksa.jsongeneric.model.JsonPropertyName;

import java.lang.reflect.Type;

class ChangeTypeListContainerSerializer implements JsonSerializer<ChangeTypeListContainer>, JsonDeserializer<ChangeTypeListContainer> {

    @Override
    public JsonElement serialize(ChangeTypeListContainer changeTypeListContainer, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        String name = changeTypeListContainer.getListName().getId();

        jsonObject.add(JsonPropertyName.CHANGE_TYPE.getId(), DefaultSerializer.toJsonTree(changeTypeListContainer.getType().getId()));
        jsonObject.add(name, DefaultSerializer.toJsonTree(changeTypeListContainer.getList()));

        return jsonObject;
    }

    @Override
    public ChangeTypeListContainer deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject= (JsonObject) jsonElement;
        String dataType=jsonObject.get(JsonPropertyName.CHANGE_TYPE.getId()).getAsString();
        Class dataClass= ChangeTypeMapping.getMappedClass(dataType);
        System.out.println(dataClass);
                
        return null;
    }
}
