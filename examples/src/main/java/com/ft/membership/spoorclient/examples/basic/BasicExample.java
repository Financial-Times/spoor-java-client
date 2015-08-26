package com.ft.membership.spoorclient.examples.basic;

import com.ft.membership.spoorclient.DefaultSpoorParameters;
import com.ft.membership.spoorclient.DefaultSpoorParametersBuilder;
import com.ft.membership.spoorclient.SpoorClient;
import com.ning.http.client.AsyncHttpClient;

import java.util.concurrent.Executors;

public class BasicExample {
    public static void main(String[] args) {
        DefaultSpoorParameters parameters = new DefaultSpoorParametersBuilder("xxxx", "https://myapp.ft.com", "my-product")
                .pageView()
                .build();

        SpoorClient spoorClient = new SpoorClient(new AsyncHttpClient(), "https://spoor-api.ft.com", Executors.newCachedThreadPool());

        spoorClient.postTracking(parameters);
    }
}
