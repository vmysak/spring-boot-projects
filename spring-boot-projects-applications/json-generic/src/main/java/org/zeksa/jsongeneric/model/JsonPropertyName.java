package org.zeksa.jsongeneric.model;

public enum JsonPropertyName {

    ENUM_VALUES("enumValues"),
    ENUM_TYPE("enumType"),
    CHANGE_TYPE("changeType"),
    DATA("data");

    private String id;

    JsonPropertyName(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
