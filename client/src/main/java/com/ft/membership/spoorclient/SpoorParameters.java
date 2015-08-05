package com.ft.membership.spoorclient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.IOException;

public class SpoorParameters<SpoorSystemType extends SpoorSystem, SpoorContextType extends SpoorContext, SpoorDeviceType extends SpoorDevice> {
    private SpoorSystemType system;
    private SpoorContextType context;
    private SpoorDeviceType device;
    private String category;
    private String action;
    static private ObjectMapper mapper = new ObjectMapper();



    static {
        mapper.registerModule(new Jdk8Module());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public SpoorParameters(SpoorSystemType system, SpoorContextType context, SpoorDeviceType device, String category, String action) {
        this.system = system;
        this.context = context;
        this.device = device;
        this.category = category;
        this.action = action;
    }

    public SpoorParameters() {
    }

    public SpoorSystemType getSystem() {
        return system;
    }

    public SpoorContextType getContext() {
        return context;
    }

    public SpoorDeviceType getDevice() {
        return device;
    }

    public String getCategory() {
        return category;
    }

    public String getAction() {
        return action;
    }

    public void setSystem(SpoorSystemType system) {
        this.system = system;
    }

    public void setContext(SpoorContextType context) {
        this.context = context;
    }

    public void setDevice(SpoorDeviceType device) {
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

    public static <T extends SpoorParameters> T fromJsonString(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

