package com.ft.membership.spoorclient.async;

import com.ning.http.client.AsyncCompletionHandler;
import com.ning.http.client.Response;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureHandler extends AsyncCompletionHandler<Response> {
    CompletableFuture<Response> future = new CompletableFuture<>();

    @Override
    public Response onCompleted(Response response) throws Exception {
        future.complete(response);
        return response;
    }

    @Override
    public void onThrowable(Throwable t) {
        future.completeExceptionally(t);
    }

    public CompletableFuture<Response> getFuture() {
        return future;
    }
}
