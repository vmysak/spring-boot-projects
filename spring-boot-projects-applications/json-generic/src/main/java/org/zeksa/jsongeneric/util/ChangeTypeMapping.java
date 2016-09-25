package org.zeksa.jsongeneric.util;

import org.zeksa.jsongeneric.dto.SectionDTO;
import org.zeksa.jsongeneric.dto.SomeObject;
import org.zeksa.jsongeneric.model.ChangeType;

import java.util.EnumMap;
import java.util.Map;

public class ChangeTypeMapping {

    public ChangeTypeMapping() {
    }

    private static final Map<ChangeType, Class> classMapping;

    static {
        classMapping = new EnumMap<>(ChangeType.class);
        classMapping.put(ChangeType.SECTIONS, SectionDTO.class);
        classMapping.put(ChangeType.SOME_OBJECT, SomeObject.class);
    }

    public static Class getMappedClass(ChangeType changeType) {
        return classMapping.get(changeType);
    }

    public static Class getMappedClass(String changeType) {
        return getMappedClass(ChangeType.getFromId(changeType));
    }

}
