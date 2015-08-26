package com.ft.membership.spoorclient.examples.customparameters;

import com.ft.membership.spoorclient.SpoorClient;
import com.ning.http.client.AsyncHttpClient;

import java.util.concurrent.Executors;

public class CustomParameterUsage {
    public static void main(String[] args) {
        CustomParameters parameters = new CustomBuilder("xxxx", "https://myapp.ft.com", "my-product")
                .withCustomParameter("my custom parameter")
                .pageView()
                .build();

        SpoorClient spoorClient = new SpoorClient(new AsyncHttpClient(), "https://spoor-api.ft.com", Executors.newCachedThreadPool());

        spoorClient.postTracking(parameters);
    }

}
