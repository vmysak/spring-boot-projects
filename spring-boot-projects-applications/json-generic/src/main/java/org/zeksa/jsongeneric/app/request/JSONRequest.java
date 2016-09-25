package org.zeksa.jsongeneric.app.request;

import org.zeksa.jsongeneric.lib.container.ObjectListContainer;
import org.zeksa.jsongeneric.lib.container.ObjectMapContainer;
import org.zeksa.jsongeneric.app.model.ChangeType;

public class JSONRequest {

    private ObjectListContainer<ChangeType> requestedForList;
    private ObjectMapContainer data;

    public ObjectListContainer<ChangeType> getRequestedForList() {
        return requestedForList;
    }

    public void setRequestedForList(ObjectListContainer<ChangeType> requestedForList) {
        this.requestedForList = requestedForList;
    }

    public ObjectMapContainer getData() {
        return data;
    }

    public void setData(ObjectMapContainer data) {
        this.data = data;
    }

}
