package org.zeksa.jsongeneric.lib.container;

import org.zeksa.jsongeneric.lib.intefaces.JSONCompatible;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ObjectMapContainer implements JSONCompatible {

    private Map<String, ObjectListContainer> map;

    private Map<String, ObjectListContainer> getMap() {
        if (map == null) {
            map = new LinkedHashMap<>();
        }
        return map;
    }

    public void add(String type, ObjectListContainer container) {
        getMap().put(type, container);
    }

    public void add(Enum type, ObjectListContainer container) {
        getMap().put(type.name(), container);
    }

    public void addAll(ObjectMapContainer container) {
        ObjectListContainer<String> keys = container.keySet();
        for (String key : keys.getList()) {
            getMap().put(key, container.getMap().get(key));
        }
    }

    public ObjectListContainer get(String type) {
        return getMap().get(type);
    }

    public ObjectListContainer get(Enum type) {
        return getMap().get(type.name());
    }

    public ObjectListContainer<String> keySet() {
        Set<String> keys = getMap().keySet();
        return new ObjectListContainer<>(keys, ObjectListContainer.TYPE);
    }

    public ObjectListContainer<?> values() {
        Collection<ObjectListContainer> values = getMap().values();
        return new ObjectListContainer<>(values, ObjectListContainer.DATA);
    }
}
