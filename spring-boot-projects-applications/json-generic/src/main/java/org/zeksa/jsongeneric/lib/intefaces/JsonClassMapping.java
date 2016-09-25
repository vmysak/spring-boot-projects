package org.zeksa.jsongeneric.lib.intefaces;

import org.zeksa.jsongeneric.app.model.ChangeType;

import java.io.Serializable;

public interface JsonClassMapping extends Serializable {

    Class getMappedClass(ChangeType changeType);

    Class getMappedClass(String changeType);

    Class<? extends Enum> getMappedEnum(String enumName);
}
