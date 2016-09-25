package org.zeksa.jsongeneric.lib.serializer;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.zeksa.jsongeneric.lib.container.ObjectListContainer;
import org.zeksa.jsongeneric.lib.intefaces.JsonClassMapping;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

class ObjectListContainerSerializer implements JsonSerializer<ObjectListContainer<?>>, JsonDeserializer<ObjectListContainer<?>> {

    private String type = ObjectListContainer.TYPE;
    private String list = ObjectListContainer.DATA;

    private JsonClassMapping mapping;

    private ObjectListContainerSerializer() {
    }

    public ObjectListContainerSerializer(JsonClassMapping mapping) {
        this.mapping = mapping;
    }

    @Override
    public JsonElement serialize(ObjectListContainer<?> container, Type t, JsonSerializationContext ctx) {
        JsonObject jsonObject = new JsonObject();

        jsonObject.add(type, DefaultSerializer.toJsonTree(container.getType()));
        jsonObject.add(list, DefaultSerializer.toJsonTree(container.getList()));

        return jsonObject;
    }

    @Override
    public ObjectListContainer<?> deserialize(JsonElement element, Type t, JsonDeserializationContext ctx) throws JsonParseException {
        JsonObject jsonObject = (JsonObject) element;

        String dataType = jsonObject.get(type).getAsString();
        Class dataClass = mapping.getMappedClass(dataType);

        JsonArray objectList = jsonObject.get(list).getAsJsonArray();

        List<Object> objects = new ArrayList<>();
        for (JsonElement e : objectList) {
            Object o = DefaultSerializer.fromJsonTree(e, dataClass);
            objects.add(o);
        }

        return new ObjectListContainer<>(objects, dataType);
    }
}
