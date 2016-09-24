package org.zeksa.jsongeneric.model;

import org.zeksa.jsongeneric.util.FieldName;

import java.util.Collection;

public class ListContainer<T> implements JSONCompatible {

    private DataType dataType;
    private ListOf<T> list;

    private ListContainer() {
    }

    public ListContainer(FieldName fieldName, DataType dataType, Collection<T> data) {
        this.dataType = dataType;
        this.list = ListOf.from(fieldName, data);
    }

    public DataType getDataType() {
        return dataType;
    }

    public ListOf<T> getList() {
        return list;
    }
}
