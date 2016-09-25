package org.zeksa.jsongeneric.app.util;

import org.zeksa.jsongeneric.app.dto.SectionDTO;
import org.zeksa.jsongeneric.app.dto.SomeObject;
import org.zeksa.jsongeneric.app.model.ChangeType;
import org.zeksa.jsongeneric.lib.intefaces.JsonClassMapping;

import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultClassMapping implements JsonClassMapping {

    private static final Map<ChangeType, Class> classMapping;
    private static final Map<String, Class<? extends Enum>> enumMapping;

    static {
        classMapping = new EnumMap<>(ChangeType.class);
        classMapping.put(ChangeType.SECTIONS, SectionDTO.class);
        classMapping.put(ChangeType.SOME_OBJECT, SomeObject.class);

        enumMapping = new LinkedHashMap<>();
        enumMapping.put(ChangeType.class.getSimpleName(), ChangeType.class);
    }

    public Class getMappedClass(ChangeType changeType) {
        return classMapping.get(changeType);
    }

    public Class getMappedClass(String changeType) {
        Class result = null;
        for (ChangeType ct : ChangeType.values()) {
            if (changeType.equals(ct.name())) {
                result = getMappedClass(ct);
            }
        }
        if (result == null) {
            result = getMappedEnum(changeType);
        }
        return result;
    }

    public Class<? extends Enum> getMappedEnum(String enumName) {
        return enumMapping.get(enumName);
    }

}
