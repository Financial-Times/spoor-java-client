package com.ft.membership.spoorclient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;

import java.io.IOException;

public class SpoorParameters {
    private SpoorSystem system;
    private SpoorContext context;
    private SpoorDevice device;
    private String category;
    private String action;
    static private ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.registerModule(new Jdk8Module());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public SpoorParameters(SpoorSystem system, SpoorContext context, SpoorDevice device, String category, String action) {
        this.system = system;
        this.context = context;
        this.device = device;
        this.category = category;
        this.action = action;
    }

    public SpoorParameters() {
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

    public void setSystem(SpoorSystem system) {
        this.system = system;
    }

    public void setContext(SpoorContext context) {
        this.context = context;
    }

    public void setDevice(SpoorDevice device) {
        this.device = device;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @JsonIgnore
    public String getJson() {

        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static SpoorParameters fromJsonString(String json) {
        return fromJsonString(json, SpoorParameters.class);
    }

    public static <T extends SpoorParameters> T fromJsonString(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpoorParameters that = (SpoorParameters) o;
        return java.util.Objects.equals(system, that.system) &&
                java.util.Objects.equals(context, that.context) &&
                java.util.Objects.equals(device, that.device) &&
                java.util.Objects.equals(category, that.category) &&
                java.util.Objects.equals(action, that.action);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(system, context, device, category, action);
    }

    @Override
    public String toString() {
        return "SpoorParameters{" +
                "system=" + system +
                ", context=" + context +
                ", device=" + device +
                ", category='" + category + '\'' +
                ", action='" + action + '\'' +
                '}';
    }
}

