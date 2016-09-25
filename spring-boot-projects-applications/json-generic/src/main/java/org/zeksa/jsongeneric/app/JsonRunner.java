package org.zeksa.jsongeneric.app;

import org.zeksa.jsongeneric.app.builder.JSONRequestBuilder;
import org.zeksa.jsongeneric.app.request.JSONRequest;
import org.zeksa.jsongeneric.app.util.DefaultClassMapping;
import org.zeksa.jsongeneric.lib.container.ObjectMapContainer;
import org.zeksa.jsongeneric.lib.container.ObjectListContainer;
import org.zeksa.jsongeneric.app.dto.SectionDTO;
import org.zeksa.jsongeneric.app.dto.SomeObject;
import org.zeksa.jsongeneric.app.dto.SubSectionDTO;
import org.zeksa.jsongeneric.app.model.ChangeType;
import org.zeksa.jsongeneric.lib.serializer.Serializer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class JsonRunner {

    public static void main(String[] args) {
        List<SectionDTO> sections = mockSections();
        SomeObject someObject = mockSomeObject();

        JSONRequest request = new JSONRequestBuilder()
                .add(ChangeType.SECTIONS, sections)
                .add(ChangeType.SOME_OBJECT, someObject)
                .build();

        sendRequest(request);
    }

    private static void sendRequest(JSONRequest request) {
        Serializer sr = Serializer.getInstance(new DefaultClassMapping());

        String requestedFor = sr.serialize(request.getRequestedForList());
        String data = sr.serialize(request.getData());

        System.out.println(requestedFor);
        System.out.println(data);

        ObjectListContainer requestedForDeserialized = sr.deserializeList(requestedFor);
        System.out.println(requestedForDeserialized);

        ObjectMapContainer dataDeserialized = sr.deserializeMap(data);
        System.out.println(dataDeserialized);
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
}
