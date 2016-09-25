package org.zeksa.jsongeneric.request;

import org.zeksa.jsongeneric.container.ChangeTypeMapContainer;
import org.zeksa.jsongeneric.container.EnumsListContainer;
import org.zeksa.jsongeneric.intefaces.EnumWithId;
import org.zeksa.jsongeneric.model.ChangeType;
import org.zeksa.jsongeneric.model.Enums;
import org.zeksa.jsongeneric.model.JsonPropertyName;

import java.util.LinkedHashSet;
import java.util.Set;

public class JSONRequest {

    private EnumsListContainer requestedFor;
    private ChangeTypeMapContainer data;

    public EnumsListContainer getRequestedFor() {
        return requestedFor;
    }

    public void setRequestedFor(EnumsListContainer requestedFor) {
        this.requestedFor = requestedFor;
    }

    public ChangeTypeMapContainer getData() {
        return data;
    }

    public void setData(ChangeTypeMapContainer data) {
        this.data = data;
        initRequestedFor();
    }

    private void initRequestedFor() {
        Set<ChangeType> types = data.keySet();
        Set<EnumWithId> converted= new LinkedHashSet<EnumWithId>(types);
        requestedFor = new EnumsListContainer(converted, Enums.CHANGE_TYPE);
    }

}
