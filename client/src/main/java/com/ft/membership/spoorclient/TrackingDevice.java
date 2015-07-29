package com.ft.membership.spoorclient;

import java.util.Optional;

public class TrackingDevice {
    private Optional<String> spoorSession;
    private Optional<String> spoorId;
    private Optional<String> userAgent;

    public TrackingDevice(Optional<String> spoorSession, Optional<String> spoorId, Optional<String> userAgent) {
        this.spoorSession = spoorSession;
        this.spoorId = spoorId;
        this.userAgent = userAgent;
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
}
