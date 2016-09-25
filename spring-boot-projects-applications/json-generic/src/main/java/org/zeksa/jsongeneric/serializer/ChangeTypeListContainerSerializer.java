package org.zeksa.jsongeneric.serializer;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.zeksa.jsongeneric.container.ChangeTypeListContainer;
import org.zeksa.jsongeneric.model.ChangeType;
import org.zeksa.jsongeneric.util.ChangeTypeMapping;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

class ChangeTypeListContainerSerializer implements JsonSerializer<ChangeTypeListContainer>, JsonDeserializer<ChangeTypeListContainer> {

    private String type = ChangeTypeListContainer.TYPE;
    private String list = ChangeTypeListContainer.DATA;

    @Override
    public JsonElement serialize(ChangeTypeListContainer container, Type t, JsonSerializationContext ctx) {
        JsonObject jsonObject = new JsonObject();

        jsonObject.add(type, DefaultSerializer.toJsonTree(container.getType().getId()));
        jsonObject.add(list, DefaultSerializer.toJsonTree(container.getList()));

        return jsonObject;
    }

    @Override
    public ChangeTypeListContainer deserialize(JsonElement element, Type t, JsonDeserializationContext ctx) throws JsonParseException {
        JsonObject jsonObject = (JsonObject) element;

        String dataType = jsonObject.get(type).getAsString();
        Class dataClass = ChangeTypeMapping.getMappedClass(dataType);

        JsonArray objectList = jsonObject.get(list).getAsJsonArray();

        List<Object> objects=new ArrayList<>();
        for (JsonElement e : objectList) {
            Object o = DefaultSerializer.fromJsonTree(e, dataClass);
            objects.add(o);
        }

        return new ChangeTypeListContainer(objects, ChangeType.getFromId(dataType));
    }
}
