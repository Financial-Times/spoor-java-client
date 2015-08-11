package com.ft.membership.spoorclient;

import com.ning.http.client.AsyncHttpClient;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.assertThat;

public class SpoorClientTest {
    ExecutorService executorService = Executors.newCachedThreadPool();

    AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
    SpoorClient client =  new SpoorClient(asyncHttpClient, "https://spoor-api.ft.com", executorService);

    @Test
    public void testClient() throws ExecutionException, InterruptedException {
        assertThat(client.postTracking(new SpoorParameters()).get().isPresent()).isTrue();
    }
}
