package org.zeksa.jsongeneric.container;

import org.apache.commons.collections4.CollectionUtils;
import org.zeksa.jsongeneric.intefaces.EnumWithId;
import org.zeksa.jsongeneric.intefaces.JSONCompatible;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ObjectListContainer<T, E extends EnumWithId> implements JSONCompatible {

    public static final String TYPE = "type";
    public static final String DATA = "data";

    private String listName;
    private E type;
    private ListOf<T> list;

    private ObjectListContainer() {
    }

    public ObjectListContainer(Collection<T> data, E type) {
        this.listName = DATA;
        this.type = type;
        this.list = ListOf.from(data);
    }

    public ObjectListContainer(T data, E type) {
        this.listName = DATA;
        this.type = type;
        this.list = ListOf.from(data);
    }

    public String getListName() {
        return listName;
    }

    public E getType() {
        return type;
    }

    public List<T> getList() {
        return list.getList();
    }

    private static class ListOf<T> implements JSONCompatible {

        private List<T> list;

        private ListOf(Collection<T> data) {
            if (!CollectionUtils.isEmpty(data)) {
                getList().addAll(data);
            }
        }

        public ListOf(T obj) {
            if (obj != null) {
                getList().add(obj);
            }
        }

        public List<T> getList() {
            if (list == null) {
                list = new ArrayList<>();
            }
            return list;
        }

        public static <T> ListOf<T> from(Collection<T> data) {
            return new ListOf<>(data);
        }

        public static <T> ListOf<T> from(T obj) {
            return new ListOf<>(obj);
        }

    }
}
