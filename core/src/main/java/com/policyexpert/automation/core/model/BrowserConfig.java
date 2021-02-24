package com.policyexpert.automation.core.model;


public class BrowserConfig {

    private String url;
    private String driverType;

    private BrowserConfig(Builder builder) {
        setUrl(builder.url);
        setDriverType(builder.driverType);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    String getDriverType() {
        return driverType;
    }

    private void setDriverType(String driverType) {
        this.driverType = driverType;
    }

    String getUrl() {
        return url;
    }

    private void setUrl(String url) {
        this.url = url;
    }

    public static final class Builder {
        private String url;
        private String driverType;

        private Builder() {
        }

        public Builder withUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder withDriverType(String driverType) {
            this.driverType = driverType;
            return this;
        }

        public BrowserConfig build() {
            return new BrowserConfig(this);
        }
    }
}
