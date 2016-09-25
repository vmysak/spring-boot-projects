package org.zeksa.jsongeneric.util;

import org.zeksa.jsongeneric.dto.SectionDTO;
import org.zeksa.jsongeneric.model.DataType;

import java.util.EnumMap;
import java.util.Map;

public class DataTypeMapping {

    public DataTypeMapping() {
    }

    private static final Map<DataType, Class> mapping;

    static {
        mapping = new EnumMap<>(DataType.class);
        mapping.put(DataType.DATA_TYPE, DataType.class);
        mapping.put(DataType.SECTION, SectionDTO.class);
    }

    public static Class getMappedClass(DataType dataType) {
        return mapping.get(dataType);
    }

    public static Class getMappedClass(String dataType) {
        return getMappedClass(DataType.valueOf(dataType));
    }

}
