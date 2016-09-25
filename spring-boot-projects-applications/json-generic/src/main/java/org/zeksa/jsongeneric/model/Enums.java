package org.zeksa.jsongeneric.model;

import org.zeksa.jsongeneric.intefaces.EnumWithId;

public enum Enums implements EnumWithId {

    CHANGE_TYPE("changeType");

    private String id;

    Enums(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public EnumWithId fromId(String id) {
        return getFromId(id);
    }

    public static Enums getFromId(String id) {
        for (Enums value : values()) {
            if (id.equals(value.getId())) {
                return value;
            }
        }
        return null;
    }

    @Override
    public EnumWithId fromName(String name) {
        return Enums.valueOf(name);
    }

    @Override
    public String getName() {
        return name();
    }

}
