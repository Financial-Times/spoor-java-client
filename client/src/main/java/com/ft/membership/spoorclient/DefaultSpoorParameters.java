package com.ft.membership.spoorclient;

public class DefaultSpoorParameters extends SpoorParameters<SpoorSystem, SpoorContext, SpoorDevice, SpoorUser>{
    public DefaultSpoorParameters(SpoorSystem system, SpoorContext context, SpoorDevice device, SpoorUser user, String category, String action) {
        super(system, context, device, user, category, action);
    }

    public DefaultSpoorParameters(){
        this(new SpoorSystem(), new SpoorContext(), new SpoorDevice(), new SpoorUser(), null, null);
    }
}
