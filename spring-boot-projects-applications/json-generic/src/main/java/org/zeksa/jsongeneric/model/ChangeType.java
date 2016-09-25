package org.zeksa.jsongeneric.model;

import org.zeksa.jsongeneric.intefaces.EnumWithId;

public enum ChangeType implements EnumWithId {

    SECTIONS("sections"),
    SOME_OBJECT("someObject");

    String id;

    ChangeType(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public EnumWithId fromId(String id) {
        return getFromId(id);
    }

    public static ChangeType getFromId(String id) {
        for (ChangeType value : values()) {
            if (id.equals(value.getId())) {
                return value;
            }
        }
        return null;
    }

    @Override
    public EnumWithId fromName(String name) {
        return ChangeType.valueOf(name);
    }

    @Override
    public String getName() {
        return name();
    }
}
