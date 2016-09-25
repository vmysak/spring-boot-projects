package org.zeksa.jsongeneric.container;

import org.zeksa.jsongeneric.intefaces.EnumWithId;
import org.zeksa.jsongeneric.model.Enums;

import java.util.Collection;

public class EnumsListContainer extends ObjectListContainer<EnumWithId, Enums> {

    public EnumsListContainer(Collection<EnumWithId> data, Enums enums) {
        super(data, enums);
    }
}
