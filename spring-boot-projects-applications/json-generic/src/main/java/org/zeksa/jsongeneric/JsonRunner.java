package org.zeksa.jsongeneric;

import org.zeksa.jsongeneric.dto.SectionDTO;
import org.zeksa.jsongeneric.dto.SubSectionDTO;
import org.zeksa.jsongeneric.model.ListContainer;
import org.zeksa.jsongeneric.model.DataContainerMap;
import org.zeksa.jsongeneric.model.DataType;
import org.zeksa.jsongeneric.model.ListOf;
import org.zeksa.jsongeneric.request.JSONRequest;
import org.zeksa.jsongeneric.serializer.Serializer;
import org.zeksa.jsongeneric.util.FieldName;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class JsonRunner {

    public static void main(String[] args) {
        List<SectionDTO> sections = mockSections();

        DataContainerMap dataContainerMap = new DataContainerMap();
        ListContainer<SectionDTO> container = new ListContainer<>(FieldName.DATA, DataType.SECTION, sections);
        dataContainerMap.getMap().put(DataType.SECTION, container);

        JSONRequest request = new JSONRequest();
        request.setData(dataContainerMap);

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

    private static void sendRequest(JSONRequest request) {
        String requestedFor = Serializer.serialize(request.getRequestedFor());
        String data = Serializer.serialize(request.getData());

        System.out.println(requestedFor);
        System.out.println(data);

        ListOf requestedForDeserialized = Serializer.deserializeListOf(requestedFor);
        System.out.println(requestedForDeserialized);
    }
}
