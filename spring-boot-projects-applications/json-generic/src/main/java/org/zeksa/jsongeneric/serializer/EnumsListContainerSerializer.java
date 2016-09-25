package org.zeksa.jsongeneric.serializer;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.zeksa.jsongeneric.container.EnumsListContainer;
import org.zeksa.jsongeneric.intefaces.EnumWithId;
import org.zeksa.jsongeneric.model.Enums;
import org.zeksa.jsongeneric.util.EnumsMapping;
import org.zeksa.jsongeneric.model.JsonPropertyName;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class EnumsListContainerSerializer implements JsonSerializer<EnumsListContainer>, JsonDeserializer<EnumsListContainer> {

    private String type = EnumsListContainer.TYPE.getId();
    private String list = EnumsListContainer.LIST.getId();

    @Override
    public JsonElement serialize(EnumsListContainer container, Type t, JsonSerializationContext ctx) {
        JsonObject jsonObject = new JsonObject();

        jsonObject.add(type, DefaultSerializer.toJsonTree(container.getType().getId()));
        jsonObject.add(list, DefaultSerializer.toJsonTree(container.getList()));

        return jsonObject;
    }

    @Override
    public EnumsListContainer deserialize(JsonElement element, Type t, JsonDeserializationContext ctx) throws JsonParseException {
        JsonObject jsonObject = (JsonObject) element;

        String enumsTypeId = jsonObject.get(type).getAsString();
        JsonArray enumList = jsonObject.get(list).getAsJsonArray();

        Class enumClass = EnumsMapping.getMappedEnum(enumsTypeId);
        EnumWithId defaultValue = (EnumWithId) enumClass.getEnumConstants()[0];

        List<EnumWithId> enums=new ArrayList<>();
        for (JsonElement e : enumList) {
            EnumWithId enumm = defaultValue.fromName(e.getAsString());
            enums.add(enumm);
        }

        return new EnumsListContainer(enums, Enums.getFromId(enumsTypeId));
    }
}
