package org.zeksa.jsongeneric.util;

import org.zeksa.jsongeneric.model.ChangeType;
import org.zeksa.jsongeneric.model.Enums;

import java.util.EnumMap;
import java.util.Map;

public class EnumsMapping {

    private EnumsMapping() {
    }

    private static final Map<Enums, Class> enumMapping;

    static {
        enumMapping = new EnumMap<>(Enums.class);
        enumMapping.put(Enums.CHANGE_TYPE, ChangeType.class);
    }

    public static Class getMappedEnum(Enums enums) {
        return enumMapping.get(enums);
    }

    public static Class getMappedEnum(String enumId) {
        return getMappedEnum(Enums.getFromId(enumId));
    }

}
