package com.ft.membership.spoorclient.examples.customparameters;

import com.ft.membership.spoorclient.SpoorDevice;
import com.ft.membership.spoorclient.SpoorParametersBuilder;
import com.ft.membership.spoorclient.SpoorSystem;
import com.ft.membership.spoorclient.SpoorUser;

import javax.servlet.http.HttpServletRequest;
import java.util.function.Function;

public class CustomBuilder extends SpoorParametersBuilder<
        SpoorSystem, CustomContext, SpoorDevice, SpoorUser, CustomParameters>
{
    private String customParameter = null;

    public CustomBuilder(String apiKey, String appRootUrl, Function<HttpServletRequest, String> productFactory) {
        super(apiKey, appRootUrl, productFactory);
    }

    public CustomBuilder(String apiKey, String appRootUrl, String product) {
        super(apiKey, appRootUrl, product);
    }

    @Override
    public CustomParameters createParameters() {
        CustomParameters customParameters = new CustomParameters();
        customParameters.getContext().setCustomParameter(this.customParameter);
        return customParameters;
    }

    public CustomBuilder withCustomParameter(String customParameter) {
        this.customParameter = customParameter;
        return this;
    }
}
