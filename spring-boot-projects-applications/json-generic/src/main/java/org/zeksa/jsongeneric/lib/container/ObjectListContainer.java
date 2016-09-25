package org.zeksa.jsongeneric.lib.container;

import org.apache.commons.collections4.CollectionUtils;
import org.zeksa.jsongeneric.lib.intefaces.JSONCompatible;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ObjectListContainer<V> implements JSONCompatible {

    public static final String TYPE = "type";
    public static final String DATA = "data";

    private String listName;
    private String type;
    private ListOf<V> list;

    private ObjectListContainer(ListOf<V> list, String type) {
        this.listName = DATA;
        this.type = type;
        this.list = list;
    }

    public ObjectListContainer(Collection<V> data, String type) {
        this(ListOf.from(data), type);
    }

    public ObjectListContainer(Collection<V> data, Enum type) {
        this(ListOf.from(data), type.name());
    }

    public ObjectListContainer(V data, String type) {
        this(ListOf.from(data), type);
    }

    public ObjectListContainer(V data, Enum type) {
        this(ListOf.from(data), type.name());
    }

    public String getListName() {
        return listName;
    }

    public String getType() {
        return type;
    }

    public List<V> getList() {
        return list.getList();
    }

    public void addAll(ObjectListContainer<V> data) {
        getList().addAll(data.getList());
    }

    private static class ListOf<V> implements JSONCompatible {

        private List<V> list;

        public ListOf(Collection<V> data) {
            if (!CollectionUtils.isEmpty(data)) {
                getList().addAll(data);
            }
        }

        public ListOf(V obj) {
            if (obj != null) {
                getList().add(obj);
            }
        }

        public List<V> getList() {
            if (list == null) {
                list = new ArrayList<>();
            }
            return list;
        }

        public static <V> ListOf<V> from(Collection<V> data) {
            return new ListOf<>(data);
        }

        public static <V> ListOf<V> from(V obj) {
            return new ListOf<>(obj);
        }

    }

}
