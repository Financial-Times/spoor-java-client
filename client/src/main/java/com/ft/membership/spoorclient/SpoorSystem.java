package com.ft.membership.spoorclient;

import com.fasterxml.jackson.annotation.JsonProperty;

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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpoorSystem that = (SpoorSystem) o;
        return Objects.equals(apiKey, that.apiKey) &&
                Objects.equals(version, that.version) &&
                Objects.equals(source, that.source);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apiKey, version, source);
    }

    @Override
    public String toString() {
        return "SpoorSystem{" +
                "apiKey='" + apiKey + '\'' +
                ", version='" + version + '\'' +
                ", source='" + source + '\'' +
                '}';
    }
}
