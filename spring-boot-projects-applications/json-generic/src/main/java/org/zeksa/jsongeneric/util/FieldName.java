package org.zeksa.jsongeneric.util;

public enum FieldName {

    REQUESTED_FOR("requestedFor"),
    DATA_TYPE("dataType"),
    DATA("data");

    private String name;

    FieldName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
