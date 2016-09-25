package org.zeksa.jsongeneric.util;

public enum ListName {

    REQUESTED_FOR("requestedFor"),
    DATA_TYPE("dataType"),
    DATA("data");

    private String name;

    ListName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
