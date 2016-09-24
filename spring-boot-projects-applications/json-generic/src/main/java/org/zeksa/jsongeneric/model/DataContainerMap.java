package org.zeksa.jsongeneric.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class DataContainerMap implements JSONCompatible {

    private Map<DataType, ListContainer> map;

    public Map<DataType, ListContainer> getMap() {
        if(map ==null){
            map =new LinkedHashMap<>();
        }
        return map;
    }
}
