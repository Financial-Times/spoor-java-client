package com.ft.membership.spoorclient;


import org.junit.Test;

import static java.util.Optional.of;
import static org.assertj.core.api.Assertions.assertThat;

public class SpoorFunnelStepDataTest {

    @Test
    public void shouldSerializeToUnderscores() {
        SpoorFunnelStepData stepData = new SpoorFunnelStepData("test", 1, "step1", 1);
        DefaultSpoorParameters trackingParameters = new DefaultSpoorParameters(
                new SpoorSystem("a", "b", "c"),
                new SpoorContext("d", of("e"), "f", "g", of(stepData)),
                new SpoorDevice(of("h"), of("i"), of("j")),
                new SpoorUser(of("session"), of("passport")),
                "k",
                "l"
        );
        String actualJson = trackingParameters.getJson();
        assertThat(actualJson).contains("funnel_name");
        assertThat(actualJson).contains("funnel_steps");
        assertThat(actualJson).contains("step_name");
        assertThat(actualJson).contains("step_number");
    }

    @Test
    public void basicInstantiationShouldWork() {
        SpoorFunnelStepData stepData = new SpoorFunnelStepData();
        stepData.setFunnelName("test");
        assertThat(stepData.getFunnelName()).isEqualTo("test");
    }
}
