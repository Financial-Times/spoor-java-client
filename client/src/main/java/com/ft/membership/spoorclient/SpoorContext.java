package com.ft.membership.spoorclient;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Optional;

public class SpoorContext {

    private String id = null;
    @JsonProperty("root_id")
    private Optional<String> rootId = Optional.empty();
    private String product = null;
    private String url = null;
    private Optional<SpoorFunnelStepData> funnel = Optional.empty();

    public SpoorContext(
            final String id,
            final Optional<String> rootId,
            final String product,
            final String url,
            final Optional<SpoorFunnelStepData> funnel) {

        this.id = id;
        this.rootId = rootId;
        this.product = product;
        this.url = url;
        this.funnel = funnel;
    }

    public SpoorContext() {
    }

    public String getId() {
        return id;
    }

    public Optional<String> getRootId() {
        return rootId;
    }

    public String getProduct() {
        return product;
    }

    public String getUrl() {
        return url;
    }

    public Optional<SpoorFunnelStepData> getFunnel() { return funnel; }

    public void setId(String id) {
        this.id = id;
    }

    public void setRootId(Optional<String> rootId) {
        this.rootId = rootId;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setFunnel(final Optional<SpoorFunnelStepData> funnel) { this.funnel = funnel; }

    @Override
    public boolean equals(Object o) {
        return new EqualsBuilder().reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this).toString();
    }

}
