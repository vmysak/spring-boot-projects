package org.zeksa.jsongeneric.request;

import org.zeksa.jsongeneric.container.MapContainer;
import org.zeksa.jsongeneric.model.DataType;
import org.zeksa.jsongeneric.container.ObjectListContainer;
import org.zeksa.jsongeneric.util.ListName;

import java.util.Set;

public class JSONRequest {

    private ObjectListContainer<DataType> requestedFor;
    private MapContainer data;

    public ObjectListContainer<DataType> getRequestedFor() {
        return requestedFor;
    }

    public void setRequestedFor(ObjectListContainer<DataType> requestedFor) {
        this.requestedFor = requestedFor;
    }

    public MapContainer getData() {
        return data;
    }

    public void setData(MapContainer data) {
        this.data = data;
        initRequestedFor();
    }

    private void initRequestedFor() {
        Set<DataType> types = data.getMap().keySet();
        requestedFor = new ObjectListContainer<>(ListName.REQUESTED_FOR, DataType.DATA_TYPE, types);
    }
}
