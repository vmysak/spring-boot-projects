package org.zeksa.jsongeneric.app.builder;

import org.zeksa.jsongeneric.app.model.ChangeType;
import org.zeksa.jsongeneric.app.request.JSONRequest;
import org.zeksa.jsongeneric.lib.container.ObjectListContainer;
import org.zeksa.jsongeneric.lib.container.ObjectMapContainer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JSONRequestBuilder {

    private JSONRequest request = new JSONRequest();

    public JSONRequestBuilder() {
        request.setData(new ObjectMapContainer());
    }

    public <T> JSONRequestBuilder add(ChangeType changeType, T data) {
        ObjectListContainer container = new ObjectListContainer<>(data, changeType);
        getListContainer(changeType).addAll(container);
        return this;
    }

    public <T> JSONRequestBuilder add(ChangeType changeType, Collection<T> data) {
        ObjectListContainer container = new ObjectListContainer<>(data, changeType);
        getListContainer(changeType).addAll(container);
        return this;
    }

    public JSONRequestBuilder add(JSONRequest r) {
        request.getData().addAll(r.getData());

        return this;
    }

    public JSONRequest build() {
        buildRequestedFor(request);
        return request;
    }

    private void buildRequestedFor(JSONRequest request) {
        ObjectListContainer<String> changeTypes = request.getData().keySet();

        List<ChangeType> list = new ArrayList<>();
        for (String changeType : changeTypes.getList()) {
            list.add(ChangeType.valueOf(changeType));
        }

        request.setRequestedForList(new ObjectListContainer<>(list, ChangeType.class.getSimpleName()));
    }

    private <T> ObjectListContainer<T> getListContainer(ChangeType changeType) {
        ObjectListContainer<T> container = request.getData().get(changeType);
        ObjectListContainer<T> emptyContainer = new ObjectListContainer(new ArrayList(), changeType);

        if (container == null) {
            request.getData().add(changeType, emptyContainer);
            return emptyContainer;
        }
        return container;
    }

}
