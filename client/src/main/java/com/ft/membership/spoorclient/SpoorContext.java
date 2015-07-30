package com.ft.membership.spoorclient;

public class SpoorContext {
    private String id;
    private String rootId;
    private String product;
    private String url;

    public SpoorContext(String id, String rootId, String product, String url) {
        this.id = id;
        this.rootId = rootId;
        this.product = product;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public String getRootId() {
        return rootId;
    }

    public String getProduct() {
        return product;
    }

    public String getUrl() {
        return url;
    }
}
