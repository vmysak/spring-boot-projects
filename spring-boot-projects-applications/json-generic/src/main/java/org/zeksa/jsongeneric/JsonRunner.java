package org.zeksa.jsongeneric;

import org.zeksa.jsongeneric.container.EnumsListContainer;
import org.zeksa.jsongeneric.dto.SectionDTO;
import org.zeksa.jsongeneric.dto.SomeObject;
import org.zeksa.jsongeneric.dto.SubSectionDTO;
import org.zeksa.jsongeneric.container.ChangeTypeListContainer;
import org.zeksa.jsongeneric.container.ChangeTypeMapContainer;
import org.zeksa.jsongeneric.model.ChangeType;
import org.zeksa.jsongeneric.request.JSONRequest;
import org.zeksa.jsongeneric.serializer.Serializer;
import org.zeksa.jsongeneric.model.JsonPropertyName;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class JsonRunner {

    public static void main(String[] args) {
        List<SectionDTO> sections = mockSections();
        SomeObject someObject = mockSomeObject();

        ChangeTypeMapContainer changeTypeMapContainer = new ChangeTypeMapContainer();
        ChangeTypeListContainer<SectionDTO> sectionsContainer = new ChangeTypeListContainer<>(sections, ChangeType.SECTIONS);
        ChangeTypeListContainer<SomeObject> someObjectContainer = new ChangeTypeListContainer<>(someObject, ChangeType.SOME_OBJECT);

        changeTypeMapContainer.put(ChangeType.SECTIONS, sectionsContainer);
        changeTypeMapContainer.put(ChangeType.SOME_OBJECT, someObjectContainer);

        JSONRequest request = new JSONRequest();
        request.setData(changeTypeMapContainer);

        sendRequest(request);
    }

    private static List<SectionDTO> mockSections() {
        SectionDTO section = new SectionDTO();
        section.setSectionId(UUID.randomUUID().toString());

        for (int i = 0; i < 3; i++) {
            SubSectionDTO subSection = new SubSectionDTO();
            subSection.setSubSectionId(UUID.randomUUID().toString());
            subSection.setAmount(BigDecimal.TEN);
            section.getSubSections().add(subSection);
        }

        return Arrays.asList(section, section);
    }

    private static SomeObject mockSomeObject() {
        SomeObject someObject = new SomeObject();
        someObject.setObjectId(UUID.randomUUID().toString());
        someObject.setSomeValue("fgdg");

        return someObject;
    }

    private static void sendRequest(JSONRequest request) {
        String requestedFor = Serializer.serialize(request.getRequestedFor());
        String data = Serializer.serialize(request.getData());

        System.out.println(requestedFor);
        System.out.println(data);

        EnumsListContainer requestedForDeserialized = Serializer.deserializeEnumsListContainer(requestedFor);
        System.out.println(requestedForDeserialized);

        ChangeTypeMapContainer dataDeserialized = Serializer.deserializeChangeTypeMapContainer(data);
        System.out.println(dataDeserialized);
    }
}
