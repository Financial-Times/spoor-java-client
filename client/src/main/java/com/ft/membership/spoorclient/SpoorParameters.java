package com.ft.membership.spoorclient;

public class SpoorParameters {
    private SpoorSystem system;
    private SpoorContext context;
    private SpoorDevice device;
    private String category;
    private String action;

    public SpoorParameters(SpoorSystem system, SpoorContext context, SpoorDevice device, String category, String action) {
        this.system = system;
        this.context = context;
        this.device = device;
        this.category = category;
        this.action = action;
    }

    public SpoorSystem getSystem() {
        return system;
    }

    public SpoorContext getContext() {
        return context;
    }

    public SpoorDevice getDevice() {
        return device;
    }

    public String getCategory() {
        return category;
    }

    public String getAction() {
        return action;
    }
}

