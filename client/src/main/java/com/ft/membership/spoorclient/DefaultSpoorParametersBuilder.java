package com.ft.membership.spoorclient;

import javax.servlet.http.HttpServletRequest;
import java.util.function.Function;

public class DefaultSpoorParametersBuilder extends SpoorParametersBuilder<
        SpoorSystem, SpoorContext, SpoorDevice, DefaultSpoorParameters>
{
        public DefaultSpoorParametersBuilder(String apiKey, String appRootUrl, Function<HttpServletRequest, String> productFactory) {
                super(apiKey, appRootUrl, productFactory);
        }

        public DefaultSpoorParametersBuilder(String apiKey, String appRootUrl, String product) {
                super(apiKey, appRootUrl, product);
        }

        @Override
        DefaultSpoorParameters createParameters() {
                return new DefaultSpoorParameters();
        }
}
