package com.ActuatorBoot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.JsonObject;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestModel {
    private String method;
    private String uri;
    private String remoteAddress;
    @JsonProperty("headers")
    private RequestHeader headerModel;

    public RequestModel() {
    }

    public RequestModel(String method, String uri, String remoteAddress, JsonObject jsonRequestHeader) {
        this.method = method;
        this.uri = uri;
        this.remoteAddress = remoteAddress;
        setHeaderModel(jsonRequestHeader);
    }

    public void setHeaderModel(JsonObject jsonRequestHeader) {
        JsonObject headers =/* jsonRequestHeader.get("headers").getAsJsonObject();*/ jsonRequestHeader;
        headerModel = new RequestHeader();
        headerModel.setHost(Arrays.asList(headers.get("host").getAsString().split(",")));
        headerModel.setConnection(Arrays.asList(headers.get("connection").getAsString().split(",")));
        try {
            headerModel.setCacheControl(Arrays.asList(headers.get("cache-control").getAsString().split(",")));
        } catch (NullPointerException e) {
            headerModel.setCacheControl(Arrays.asList());
        }

        try {
            headerModel.setUpgradeInsecureRequests(Arrays.asList(headers.get("upgrade-insecure-requests").getAsString().split(",")));
        } catch (NullPointerException e) {
            headerModel.setUpgradeInsecureRequests(Arrays.asList());
        }

        try {
            headerModel.setUserAgent(Arrays.asList(headers.get("user-agent").getAsString().split(",")));
        } catch (NullPointerException e) {
            headerModel.setUserAgent(Arrays.asList());
        }
        headerModel.setAccept(Arrays.asList(headers.get("accept").getAsString().split(",")));
        try {
            headerModel.setAcceptEncoding(Arrays.asList(headers.get("accept-encoding").getAsString().split(",")));
        } catch (NullPointerException e) {
            headerModel.setAcceptEncoding(Arrays.asList());
        }
        try {
            headerModel.setAcceptLanguage(Arrays.asList(headers.get("accept-language").getAsString().split(",")));
        } catch (NullPointerException e) {
            headerModel.setAcceptLanguage(Arrays.asList());
        }
    }

    public String getMethod() {
        return method;
    }

    public String getUri() {
        return uri;
    }

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public RequestHeader getHeaderModel() {
        return headerModel;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
    }
}
