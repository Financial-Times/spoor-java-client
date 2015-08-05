package com.ft.membership.spoorclient;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

public class SpoorDevice {
    @JsonProperty("spoor_session")
    private Optional<String> spoorSession = Optional.empty();
    @JsonProperty("spoor_id")
    private Optional<String> spoorId = Optional.empty();
    @JsonProperty("user_agent")
    private Optional<String> userAgent = Optional.empty();

    public SpoorDevice(Optional<String> spoorSession, Optional<String> spoorId, Optional<String> userAgent) {
        this.spoorSession = spoorSession;
        this.spoorId = spoorId;
        this.userAgent = userAgent;
    }

    public SpoorDevice() {
    }

    public Optional<String> getSpoorSession() {
        return spoorSession;
    }

    public Optional<String> getSpoorId() {
        return spoorId;
    }

    public Optional<String> getUserAgent() {
        return userAgent;
    }

    public void setSpoorSession(Optional<String> spoorSession) {
        this.spoorSession = spoorSession;
    }

    public void setSpoorId(Optional<String> spoorId) {
        this.spoorId = spoorId;
    }

    public void setUserAgent(Optional<String> userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpoorDevice that = (SpoorDevice) o;
        return Objects.equals(spoorSession, that.spoorSession) &&
                Objects.equals(spoorId, that.spoorId) &&
                Objects.equals(userAgent, that.userAgent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(spoorSession, spoorId, userAgent);
    }

    @Override
    public String toString() {
        return "SpoorDevice{" +
                "spoorSession=" + spoorSession +
                ", spoorId=" + spoorId +
                ", userAgent=" + userAgent +
                '}';
    }
}
