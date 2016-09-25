package org.zeksa.jsongeneric.container;

import org.zeksa.jsongeneric.intefaces.JSONCompatible;
import org.zeksa.jsongeneric.model.ChangeType;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class ChangeTypeMapContainer implements JSONCompatible {

    private Map<String, ChangeTypeListContainer> map;

    private Map<String, ChangeTypeListContainer> getMap() {
        if (map == null) {
            map = new LinkedHashMap<>();
        }
        return map;
    }

    public void put(ChangeType type, ChangeTypeListContainer container) {
        getMap().put(type.getId(), container);
    }

    public Set<ChangeType> keySet() {
        Set<ChangeType> result = new LinkedHashSet<>();

        Set<String> keySet = getMap().keySet();
        for (String key : keySet) {
            result.add(ChangeType.getFromId(key));
        }
        return result;
    }
}
