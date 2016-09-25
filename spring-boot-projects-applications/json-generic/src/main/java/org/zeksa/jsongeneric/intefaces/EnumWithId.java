package org.zeksa.jsongeneric.intefaces;

public interface EnumWithId {

    EnumWithId fromId(String id);

    String getId();

    EnumWithId fromName(String name);

    String getName();

}
