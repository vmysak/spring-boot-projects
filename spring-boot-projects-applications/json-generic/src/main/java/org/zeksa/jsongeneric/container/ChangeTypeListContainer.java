package org.zeksa.jsongeneric.container;

import org.zeksa.jsongeneric.model.ChangeType;
import org.zeksa.jsongeneric.model.JsonPropertyName;

import java.util.Collection;

public class ChangeTypeListContainer<T> extends ObjectListContainer<T, ChangeType> {

    public static final JsonPropertyName TYPE = JsonPropertyName.CHANGE_TYPE;
    public static final JsonPropertyName LIST = JsonPropertyName.DATA;

    public ChangeTypeListContainer(Collection<T> data, ChangeType changeType) {
        super(LIST, data, changeType);
    }

    public ChangeTypeListContainer(T data, ChangeType changeType) {
        super(LIST, data, changeType);
    }
}
