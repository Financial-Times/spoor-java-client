package com.ft.membership.spoorclient;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class SpoorParametersBuilder<
        CustomSpoorSystem extends SpoorSystem,
        CustomSpoorContext extends SpoorContext,
        CustomSpoorDevice extends SpoorDevice,
        CustomSpoorUser extends SpoorUser,
        CustomSpoorParameters extends SpoorParameters<CustomSpoorSystem, CustomSpoorContext, CustomSpoorDevice, SpoorUser>
        >
{
    protected CustomSpoorParameters instance = createParameters();

    protected abstract CustomSpoorParameters createParameters();

    String apiKey;
    String version = this.getClass().getPackage().getImplementationVersion();
    String appRootUrl;
    Function<HttpServletRequest, String> productFactory;

    protected void buildSpoorContextFromRequest(SpoorContext spoorContext, HttpServletRequest request, Optional<String> rootId) {
        spoorContext.setId(UUID.randomUUID().toString());
        spoorContext.setRootId(rootId.orElse(UUID.randomUUID().toString()));
        spoorContext.setProduct(productFactory.apply(request));
        spoorContext.setUrl(replaceUriRoot(getFullURL(request)));
    }

    protected void buildSpoorDeviceFromRequest(SpoorDevice device, HttpServletRequest request) {
        device.setSpoorSession(getCookieValue(request, "FTSession"));
        device.setSpoorId(getCookieValue(request, "spoor-id"));
        device.setUserAgent(getHeader(request, "User-Agent"));
    }

    protected void buildSpoorSystem(SpoorSystem system) {
        system.setApiKey(apiKey);
        system.setVersion("1.0.0");
        system.setSource("spoor-java-client");
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
        Cookie[] cookies = request.getCookies();
        if(cookies == null) {
            return Optional.empty();
        } else {
            return Arrays.stream(cookies)
                    .filter((cookie) -> cookie.getName().equals(cookieKey))
                    .map(Cookie::getValue)
                    .findFirst();
        }
    }

    private Optional<String> getHeader(HttpServletRequest request, String headerName) {
        return Optional.ofNullable(request.getHeader(headerName));
    }

    private String getFullURL(HttpServletRequest request) {
        StringBuffer requestURL = request.getRequestURL();
        String queryString = request.getQueryString();

        if (queryString == null) {
            return requestURL.toString();
        } else {
            return requestURL.append('?').append(queryString).toString();
        }
    }

    public SpoorParametersBuilder<CustomSpoorSystem, CustomSpoorContext, CustomSpoorDevice, CustomSpoorUser, CustomSpoorParameters> pageView() {
        instance.setCategory("page");
        instance.setAction("view");
        return this;
    }

    public SpoorParametersBuilder<CustomSpoorSystem, CustomSpoorContext, CustomSpoorDevice, CustomSpoorUser, CustomSpoorParameters> event(String action, String category) {
        instance.setCategory(category);
        instance.setAction(action);
        return this;
    }

    public CustomSpoorParameters build() {
        return instance;
    }

    public SpoorParametersBuilder<CustomSpoorSystem, CustomSpoorContext, CustomSpoorDevice, CustomSpoorUser, CustomSpoorParameters> fromRequest(HttpServletRequest request, Optional<String> rootId) {
        buildSpoorSystem(instance.getSystem());
        buildSpoorContextFromRequest(instance.getContext(), request, rootId);
        buildSpoorDeviceFromRequest(instance.getDevice(), request);
        instance.setAction("view");
        instance.setCategory("page");
        return this;
    }

    public SpoorParametersBuilder(String apiKey, String appRootUrl, Function<HttpServletRequest, String> productFactory) {
        this.apiKey = apiKey;
        this.appRootUrl = appRootUrl;
        this.productFactory = productFactory;
    }

    public SpoorParametersBuilder(String apiKey, String appRootUrl, String product) {
        this.apiKey = apiKey;
        this.appRootUrl = appRootUrl;
        this.productFactory = (request) -> product;
    }
}
