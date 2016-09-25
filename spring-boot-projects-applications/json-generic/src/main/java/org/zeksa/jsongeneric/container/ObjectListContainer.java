package org.zeksa.jsongeneric.container;

import org.apache.commons.collections4.CollectionUtils;
import org.zeksa.jsongeneric.intefaces.JSONCompatible;
import org.zeksa.jsongeneric.model.DataType;
import org.zeksa.jsongeneric.util.ListName;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ObjectListContainer<T> implements JSONCompatible {

    private ListName listName;
    private DataType dataType;
    private ListOf<T> list;

    private ObjectListContainer() {
    }

    public ObjectListContainer(ListName listName, DataType dataType, Collection<T> data) {
        this.listName = listName;
        this.dataType = dataType;
        this.list = ListOf.from(data);
    }

    public ListName getListName() {
        return listName;
    }

    public DataType getDataType() {
        return dataType;
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
