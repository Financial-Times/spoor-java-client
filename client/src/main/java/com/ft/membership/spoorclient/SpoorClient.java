package com.ft.membership.spoorclient;

import com.ft.membership.spoorclient.async.CompletableFutureHandler;
import com.ning.http.client.AsyncHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class SpoorClient {
    private AsyncHttpClient httpClient;
    private String spoorApiRoot;
    private Executor executor;

    private Logger log = LoggerFactory.getLogger(SpoorClient.class);

    public SpoorClient(AsyncHttpClient httpClient, String spoorApiRoot, Executor executor) {
        this.httpClient = httpClient;
        this.spoorApiRoot = spoorApiRoot;
        this.executor = executor;
    }

    public CompletableFuture<Boolean> postTracking(SpoorParameters spoorParameters) {
        AsyncHttpClient.BoundRequestBuilder boundRequestBuilder = httpClient.preparePost(spoorApiRoot + "/px.gif");

        boundRequestBuilder.setBody(spoorParameters.getJson());
        boundRequestBuilder.setHeader("ContentType", "application/json");

        CompletableFutureHandler completableFutureHandler = new CompletableFutureHandler();
        boundRequestBuilder.execute(completableFutureHandler);

        return completableFutureHandler.getFuture().thenApplyAsync(
            (response) -> {
                int statusCode = response.getStatusCode();
                boolean success = statusCode == 202;
                if(!success) {
                    String responseBody = "Failed to get response body";
                    try {
                        responseBody = response.getResponseBody();
                    } catch (IOException e) {
                        //do nothing
                    }
                    log.error("Call to spoor api failed status was:" + statusCode + " response was: " + responseBody);
                }

                return success;
            },
            this.executor
        );
    }
}
