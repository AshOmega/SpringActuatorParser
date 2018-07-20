package com.ActuatorBoot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestHeader {
    private List<String> host;
    private List<String> connection;
    private List<String> pragma;
    @JsonProperty("cache-control")
    private List<String> cacheControl;
    @JsonProperty("user-agent")
    private List<String> userAgent;
    private List<String> accept;
    private List<String> referer;
    @JsonProperty("accept-encoding")
    private List<String> acceptEncoding;
    @JsonProperty("upgrade-insecure-requests")
    private List<String> acceptLanguage;
    @JsonProperty("upgrade-insecure-requests")
    private List<String> upgradeInsecureRequests;

    public RequestHeader(List<String> host, List<String> connection, List<String> pragma, List<String> cacheControl,
                         List<String> userAgent, List<String> accept, List<String> referer, List<String> acceptEncoding,
                         List<String> acceptLanguage, List<String> upgradeInsecureRequests) {
        this.host = host;
        this.connection = connection;
        this.pragma = pragma;
        this.cacheControl = cacheControl;
        this.userAgent = userAgent;
        this.accept = accept;
        this.referer = referer;
        this.acceptEncoding = acceptEncoding;
        this.acceptLanguage = acceptLanguage;
        this.upgradeInsecureRequests = upgradeInsecureRequests;
    }

    public RequestHeader() {
    }

    public List<String> getHost() {
        return host;
    }

    public List<String> getconnection() {
        return connection;
    }

    public List<String> getPragma() {
        return pragma;
    }

    public List<String> getCacheControl() {
        return cacheControl;
    }

    public List<String> getUserAgent() {
        return userAgent;
    }

    public List<String> getAccept() {
        return accept;
    }

    public List<String> getReferer() {
        return referer;
    }

    public List<String> getAcceptEncoding() {
        return acceptEncoding;
    }

    public List<String> getAcceptLanguage() {
        return acceptLanguage;
    }

    public void setHost(List<String> host) {
        this.host = host;
    }

    public void setConnection(List<String> connection) {
        this.connection = connection;
    }

    public void setPragma(List<String> pragma) {
        this.pragma = pragma;
    }

    public void setCacheControl(List<String> cacheControl) {
        this.cacheControl = cacheControl;
    }

    public void setUserAgent(List<String> userAgent) {
        this.userAgent = userAgent;
    }

    public void setAccept(List<String> accept) {
        this.accept = accept;
    }

    public void setReferer(List<String> referer) {
        this.referer = referer;
    }

    public void setAcceptEncoding(List<String> acceptEncoding) {
        this.acceptEncoding = acceptEncoding;
    }

    public void setAcceptLanguage(List<String> acceptLanguage) {
        this.acceptLanguage = acceptLanguage;
    }

    public void setUpgradeInsecureRequests(List<String> upgradeInsecureRequests) {
        this.upgradeInsecureRequests = upgradeInsecureRequests;
    }
}
