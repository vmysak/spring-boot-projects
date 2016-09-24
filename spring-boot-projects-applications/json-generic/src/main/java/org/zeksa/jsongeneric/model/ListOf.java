package org.zeksa.jsongeneric.model;

import org.apache.commons.collections4.CollectionUtils;
import org.zeksa.jsongeneric.util.FieldName;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListOf<T> implements JSONCompatible {

    private String name;
    private List<T> list;

    private ListOf(String name, Collection<T> data) {
        this.name = name;
        if (!CollectionUtils.isEmpty(data)) {
            getList().addAll(data);
        }
    }

    private ListOf(String name, T obj) {
        this.name = name;
        if (obj != null) {
            getList().add(obj);
        }
    }

    public String getName() {
        return name;
    }

    public List<T> getList() {
        if (list == null) {
            list = new ArrayList<>();
        }
        return list;
    }

    static <T> ListOf<T> from(FieldName name, Collection<T> data) {
        return new ListOf<>(name.getName(), data);
    }

    static <T> ListOf<T> from(FieldName name, T obj) {
        return new ListOf<>(name.getName(), obj);
    }

    static <T> ListOf<T> from(String name, Collection<T> data) {
        return new ListOf<>(name, data);
    }

    static <T> ListOf<T> from(String name, T obj) {
        return new ListOf<>(name, obj);
    }
}
