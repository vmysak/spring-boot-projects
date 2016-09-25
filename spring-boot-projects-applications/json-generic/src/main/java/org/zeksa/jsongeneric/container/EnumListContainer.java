package org.zeksa.jsongeneric.container;

import org.zeksa.jsongeneric.model.DataType;
import org.zeksa.jsongeneric.util.ListName;

import java.util.Collection;

public class EnumListContainer<T> extends ObjectListContainer<T> {

    public EnumListContainer(ListName listName, DataType dataType, Collection<T> data) {
        super(listName, dataType, data);
    }
}
