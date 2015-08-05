package com.ft.membership.spoorclient;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Objects;

public class SpoorSystem {
    @JsonProperty("api_key")
    private String apiKey;
    private String version;
    private String source;

    public SpoorSystem(String apiKey, String version, String source) {
        this.apiKey = apiKey;
        this.version = version;
        this.source = source;
    }

    public SpoorSystem() {
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getVersion() {
        return version;
    }

    public String getSource() {
        return source;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setSource(String source) {
        this.source = source;
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
