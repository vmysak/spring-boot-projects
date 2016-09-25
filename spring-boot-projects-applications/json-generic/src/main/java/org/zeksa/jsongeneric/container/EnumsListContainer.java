package org.zeksa.jsongeneric.container;

import org.zeksa.jsongeneric.intefaces.EnumWithId;
import org.zeksa.jsongeneric.model.Enums;
import org.zeksa.jsongeneric.model.JsonPropertyName;

import java.util.Collection;

public class EnumsListContainer extends ObjectListContainer<EnumWithId, Enums> {

    public static final JsonPropertyName TYPE = JsonPropertyName.ENUM_TYPE;
    public static final JsonPropertyName LIST = JsonPropertyName.ENUM_VALUES;

    public EnumsListContainer(Collection<EnumWithId> data, Enums enums) {
        super(LIST, data, enums);
    }
}
