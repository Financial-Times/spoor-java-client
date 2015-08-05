package com.ft.membership.spoorclient;

public class DefaultSpoorParameters extends SpoorParameters<SpoorSystem, SpoorContext, SpoorDevice>{
    public DefaultSpoorParameters(SpoorSystem system, SpoorContext context, SpoorDevice device, String category, String action) {
        super(system, context, device, category, action);
    }

    public DefaultSpoorParameters(){
        this(new SpoorSystem(), new SpoorContext(), new SpoorDevice(), null, null);
    }
}
