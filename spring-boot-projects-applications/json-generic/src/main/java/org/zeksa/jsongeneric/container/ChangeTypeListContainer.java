package org.zeksa.jsongeneric.container;

import org.zeksa.jsongeneric.model.ChangeType;
import org.zeksa.jsongeneric.model.JsonPropertyName;

import java.util.Collection;

public class ChangeTypeListContainer<T> extends ObjectListContainer<T, ChangeType> {

    public ChangeTypeListContainer(JsonPropertyName listName, Collection<T> data, ChangeType changeType) {
        super(listName, data, changeType);
    }

    public ChangeTypeListContainer(JsonPropertyName listName, T data, ChangeType changeType) {
        super(listName, data, changeType);
    }
}
