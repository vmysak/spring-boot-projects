package org.zeksa.jsongeneric.app.dto;

import java.math.BigDecimal;

public class SubSectionDTO {

    private String subSectionId;
    private BigDecimal amount;

    public String getSubSectionId() {
        return subSectionId;
    }

    public void setSubSectionId(String subSectionId) {
        this.subSectionId = subSectionId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
