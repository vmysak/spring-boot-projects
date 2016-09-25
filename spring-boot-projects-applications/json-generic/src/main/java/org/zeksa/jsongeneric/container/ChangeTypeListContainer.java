package org.zeksa.jsongeneric.container;

import org.zeksa.jsongeneric.model.ChangeType;

import java.util.Collection;

public class ChangeTypeListContainer<T> extends ObjectListContainer<T, ChangeType> {

    public ChangeTypeListContainer(Collection<T> data, ChangeType changeType) {
        super(data, changeType);
    }

    public ChangeTypeListContainer(T data, ChangeType changeType) {
        super(data, changeType);
    }
}
