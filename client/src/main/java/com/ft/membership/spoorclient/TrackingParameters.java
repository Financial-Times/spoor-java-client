package com.ft.membership.spoorclient;

public class TrackingParameters {
    private TrackingSystem system;
    private TrackingContext context;
    private TrackingDevice device;
    private String category;
    private String action;

    public TrackingParameters(TrackingSystem system, TrackingContext context, TrackingDevice device, String category, String action) {
        this.system = system;
        this.context = context;
        this.device = device;
        this.category = category;
        this.action = action;
    }

    public TrackingSystem getSystem() {
        return system;
    }

    public TrackingContext getContext() {
        return context;
    }

    public TrackingDevice getDevice() {
        return device;
    }

    public String getCategory() {
        return category;
    }

    public String getAction() {
        return action;
    }
}

