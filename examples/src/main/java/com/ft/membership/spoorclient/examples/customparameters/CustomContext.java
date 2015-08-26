package com.ft.membership.spoorclient.examples.customparameters;

import com.ft.membership.spoorclient.SpoorContext;

import java.util.Optional;

public class CustomContext extends SpoorContext {
    private String customParameter;

    public CustomContext(String id, Optional<String> rootId, String product, String url, String customParameter) {
        super(id, rootId, product, url);
        this.customParameter = customParameter;
    }

    public CustomContext() {
        super();
        customParameter = null;
    }

    public String getCustomParameter() {
        return customParameter;
    }

    public void setCustomParameter(String customParameter) {
        this.customParameter = customParameter;
    }
}
