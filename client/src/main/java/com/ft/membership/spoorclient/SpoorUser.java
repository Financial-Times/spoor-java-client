package com.ft.membership.spoorclient;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class SpoorUser {
    @JsonProperty("ft_session")
    private String ftSession;

    @JsonProperty("passport_id")
    private String passportId;

    public SpoorUser(String ftSession, String passportId) {
        this.ftSession = ftSession;
        this.passportId = passportId;
    }

    public SpoorUser() {
        this(null, null);
    }

    public String getFtSession() {
        return ftSession;
    }

    public void setFtSession(String ftSession) {
        this.ftSession = ftSession;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
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