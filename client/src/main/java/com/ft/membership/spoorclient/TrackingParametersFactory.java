package com.ft.membership.spoorclient;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrackingParametersFactory {
    String apiKey;
    String version = this.getClass().getPackage().getImplementationVersion();
    String appRootUrl;
    String product;


    public TrackingParameters fromRequest(HttpServletRequest request, Optional<String> rootId) {
        TrackingSystem trackingSystem = new TrackingSystem(apiKey, version, "spoor-java-client");


        TrackingDevice trackingDevice = new TrackingDevice(
                getCookieValue(request, "FTSession"),
                getCookieValue(request, "spoor-id"),
                getHeader(request, "User-Agent")
        );

        TrackingContext trackingContext = new TrackingContext(
                UUID.randomUUID().toString(),
                rootId.orElse(UUID.randomUUID().toString()),
                product,
                replaceUriRoot(request.getRequestURI())
        );

        return new TrackingParameters(trackingSystem, trackingContext, trackingDevice, "page", "view");
    }

    private Pattern uriReplaceRegexp = Pattern.compile("https?://.*?(/.*)");

    private String replaceUriRoot(String requestURI) {
        Matcher matcher = uriReplaceRegexp.matcher(requestURI);
        if(!matcher.matches()) {
            throw new RuntimeException("Failed to replace root of uri:" + requestURI);
        }

        return appRootUrl + matcher.group(1);
    }

    private Optional<String> getCookieValue(HttpServletRequest request, String cookieKey) {
        return Arrays.stream(request.getCookies())
            .filter((cookie) -> cookie.getName().equals(cookieKey))
            .map((cookie) -> cookie.getValue())
            .findFirst();
    }

    private Optional<String> getHeader(HttpServletRequest request, String headerName) {
        return Optional.ofNullable(request.getHeader(headerName));
    }

    public TrackingParametersFactory(String apiKey, String appRootUrl, String product) {
        this.apiKey = apiKey;
        this.appRootUrl = appRootUrl;
        this.product = product;
    }
}