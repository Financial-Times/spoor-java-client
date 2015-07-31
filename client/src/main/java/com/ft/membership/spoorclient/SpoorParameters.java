package com.ft.membership.spoorclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;

public class SpoorParameters {
    private SpoorSystem system;
    private SpoorContext context;
    private SpoorDevice device;
    private String category;
    private String action;
    static private ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.registerModule(new Jdk8Module());
    }

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

    public String toJSON() {

        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }
}

