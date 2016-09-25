package org.zeksa.jsongeneric;

import org.zeksa.jsongeneric.dto.SectionDTO;
import org.zeksa.jsongeneric.dto.SubSectionDTO;
import org.zeksa.jsongeneric.container.ObjectListContainer;
import org.zeksa.jsongeneric.container.MapContainer;
import org.zeksa.jsongeneric.model.DataType;
import org.zeksa.jsongeneric.request.JSONRequest;
import org.zeksa.jsongeneric.serializer.Serializer;
import org.zeksa.jsongeneric.util.ListName;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class JsonRunner {

    public static void main(String[] args) {
        List<SectionDTO> sections = mockSections();

        MapContainer mapContainer = new MapContainer();
        ObjectListContainer<SectionDTO> container = new ObjectListContainer<>(ListName.DATA, DataType.SECTION, sections);
        mapContainer.getMap().put(DataType.SECTION, container);

        JSONRequest request = new JSONRequest();
        request.setData(mapContainer);

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

        ObjectListContainer requestedForDeserialized = Serializer.deserializeListContainer(requestedFor);
        System.out.println(requestedForDeserialized);
    }
}
