package org.zeksa.jsongeneric.app.dto;

import java.util.ArrayList;
import java.util.List;

public class SectionDTO {

    private String sectionId;
    private List<SubSectionDTO> subSections;

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public List<SubSectionDTO> getSubSections() {
        if (subSections == null) {
            subSections = new ArrayList<>();
        }
        return subSections;
    }

    public void setSubSections(List<SubSectionDTO> subSections) {
        this.subSections = subSections;
    }
}
