package com.ft.membership.spoorclient.examples.customparameters;

import com.ft.membership.spoorclient.*;

public class CustomParameters extends SpoorParameters<SpoorSystem, CustomContext, SpoorDevice, SpoorUser> {
    public CustomParameters (SpoorSystem system, CustomContext context, SpoorDevice device, SpoorUser user, String category, String action) {
        super(system, context, device, user, category, action);
    }

    public CustomParameters (){
        this(new SpoorSystem(), new CustomContext(), new SpoorDevice(), new SpoorUser(), null, null);
    }
}
