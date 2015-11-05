package com.ft.membership.spoorclient;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class SpoorFunnelStepData {

    private String funnelName;
    private int funnelSteps;
    private String stepName;
    private int stepNumber;

    public SpoorFunnelStepData() {
        // default constructor for Jackson
    }

    public SpoorFunnelStepData(
            final String funnelName, final int funnelSteps, final String stepName, final int stepNumber) {

        this.funnelName = funnelName;
        this.funnelSteps = funnelSteps;
        this.stepName = stepName;
        this.stepNumber = stepNumber;
    }

    public String getFunnelName() {
        return funnelName;
    }

    public void setFunnelName(final String funnelName) {
        this.funnelName = funnelName;
    }

    public int getFunnelSteps() {
        return funnelSteps;
    }

    public void setFunnelSteps(final int funnelSteps) {
        this.funnelSteps = funnelSteps;
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(final String stepName) {
        this.stepName = stepName;
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(final int stepNumber) {
        this.stepNumber = stepNumber;
    }

    @Override
    public boolean equals(Object o) {
        return new EqualsBuilder().reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this).toString();
    }
}
