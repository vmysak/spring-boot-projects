package org.zeksa.jsongeneric.container;

import org.zeksa.jsongeneric.intefaces.JSONCompatible;
import org.zeksa.jsongeneric.model.DataType;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapContainer implements JSONCompatible {

    private Map<DataType, ObjectListContainer> map;

    public Map<DataType, ObjectListContainer> getMap() {
        if(map ==null){
            map =new LinkedHashMap<>();
        }
        return map;
    }
}
