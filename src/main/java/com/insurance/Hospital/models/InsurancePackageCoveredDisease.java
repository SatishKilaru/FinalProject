package com.insurance.Hospital.models;

public class InsurancePackageCoveredDisease {
    private int inspId;
    private int discId;

    // Default constructor
    public InsurancePackageCoveredDisease() {
    }

    // Parameterized constructor
    public InsurancePackageCoveredDisease(int inspId, int discId) {
        this.inspId = inspId;
        this.discId = discId;
    }

    // Getter for inspId
    public int getInspId() {
        return inspId;
    }

    // Setter for inspId
    public void setInspId(int inspId) {
        this.inspId = inspId;
    }

    // Getter for discId
    public int getDiscId() {
        return discId;
    }

    // Setter for discId
    public void setDiscId(int discId) {
        this.discId = discId;
    }

    @Override
    public String toString() {
        return "InsurancePackageCoveredDisease{" +
                "inspId=" + inspId +
                ", discId=" + discId +
                '}';
    }
}
