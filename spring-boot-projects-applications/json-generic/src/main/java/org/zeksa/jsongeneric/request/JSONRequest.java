package org.zeksa.jsongeneric.request;

import org.zeksa.jsongeneric.model.DataContainerMap;
import org.zeksa.jsongeneric.model.DataType;
import org.zeksa.jsongeneric.model.ListContainer;
import org.zeksa.jsongeneric.util.FieldName;

import java.util.Set;

public class JSONRequest {

    private ListContainer<DataType> requestedFor;
    private DataContainerMap data;

    public ListContainer<DataType> getRequestedFor() {
        return requestedFor;
    }

    public void setRequestedFor(ListContainer<DataType> requestedFor) {
        this.requestedFor = requestedFor;
    }

    public DataContainerMap getData() {
        return data;
    }

    public void setData(DataContainerMap data) {
        this.data = data;
        initRequestedFor();
    }

    private void initRequestedFor() {
        Set<DataType> types = data.getMap().keySet();
        requestedFor = new ListContainer<>(FieldName.REQUESTED_FOR, DataType.DATA_TYPE, types);
    }
}
