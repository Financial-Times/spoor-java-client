package com.ft.membership.spoorclient;

public class SpoorSystem {
    private String apiKey;
    private String version;
    private String source;

    public SpoorSystem(String apiKey, String version, String source) {
        this.apiKey = apiKey;
        this.version = version;
        this.source = source;
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
}
