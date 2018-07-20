package com.ActuatorBoot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.JsonObject;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseModel {

    private String status;
    @JsonProperty("headers")
    ResponseHeader responseHeaderModel;

    public ResponseModel() {
    }

    public ResponseModel(String status, JsonObject jsonResponseHeader) {
        this.status = status;
        setResponseHeaderModel(jsonResponseHeader);
    }

    public void setResponseHeaderModel(JsonObject jsonResponseHeader) {
        responseHeaderModel = new ResponseHeader();
        responseHeaderModel.setContentType(Arrays.asList(jsonResponseHeader.get("Content-Type").getAsString().split(",")));
        try {
            responseHeaderModel.setTransferEncoding(Arrays.asList(jsonResponseHeader.get("Transfer-Encoding").getAsString().split(",")));
        } catch (NullPointerException e) {
            responseHeaderModel.setTransferEncoding(Arrays.asList());
        }
        responseHeaderModel.setDate(Arrays.asList(jsonResponseHeader.get("Date").getAsString().split(",")));
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public ResponseHeader getResponseHeaderModel() {
        return responseHeaderModel;
    }
}
