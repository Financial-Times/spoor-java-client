package com.ft.membership.spoorclient;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class SpoorContext {

    private String id;
    @JsonProperty("root_id")
    private String rootId;
    private String product;
    private String url;

    public SpoorContext(String id, String rootId, String product, String url) {
        this.id = id;
        this.rootId = rootId;
        this.product = product;
        this.url = url;
    }

    public SpoorContext() {
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

    public void setId(String id) {
        this.id = id;
    }

    public void setRootId(String rootId) {
        this.rootId = rootId;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpoorContext that = (SpoorContext) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(rootId, that.rootId) &&
                Objects.equals(product, that.product) &&
                Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rootId, product, url);
    }

    @Override
    public String toString() {
        return "SpoorContext{" +
                "id='" + id + '\'' +
                ", rootId='" + rootId + '\'' +
                ", product='" + product + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
