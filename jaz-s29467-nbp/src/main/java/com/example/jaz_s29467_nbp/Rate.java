package com.example.jaz_s29467_nbp;

import io.swagger.v3.oas.annotations.media.Schema;

public class Rate {
    @Schema(description = "Effective date", example = "2015-01-11")
    private String effectiveDate;
    @Schema(description = "Exchange rate", example = "3.12345")
    private double mid;

    public String getEffectiveDate() {
        return effectiveDate;
    }
    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public double getMid() {
        return mid;
    }
    public void setMid(double mid) {
        this.mid = mid;
    }
}