package com.ActuatorBoot.Impl;

import com.ActuatorBoot.model.RequestModel;
import com.ActuatorBoot.model.ResponseModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.JsonObject;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActuatorModel {
    private String timestamp;
    private String principal;
    private String session;
    private Long timeTaken;

    @JsonProperty("request")
    private RequestModel requestModel;
    @JsonProperty("response")
    private ResponseModel responseModel;


    public ActuatorModel() {
    }


    public ActuatorModel(String timestamp, String principal, String session, JsonObject jSonRequestModel, JsonObject jSonResponseModel, Long timeTaken) {
        this.timestamp = timestamp;
        this.principal = principal;
        this.session = session;
        this.timeTaken = timeTaken;

        setRequestModel(jSonRequestModel);
        setResponseModel(jSonResponseModel);
    }

    private void setResponseModel(JsonObject jSonResponseModel) {
        responseModel = new ResponseModel();
        responseModel.setStatus(jSonResponseModel.get("status").getAsString());
        responseModel.setResponseHeaderModel(jSonResponseModel.get("headers").getAsJsonObject());

    }

    private void setRequestModel(JsonObject jSonRequestModel) {
        requestModel = new RequestModel();
        requestModel.setMethod(jSonRequestModel.get("method").getAsString());

        try {
            requestModel.setRemoteAddress(jSonRequestModel.get("remoteAddress").getAsString());
        } catch (Exception e) {
            requestModel.setRemoteAddress("null");
        }
        requestModel.setUri(jSonRequestModel.get("uri").getAsString());
        requestModel.setHeaderModel(jSonRequestModel.get("headers").getAsJsonObject());
    }

    public ResponseModel getResponseModel() {
        return responseModel;
    }

    public RequestModel getRequestModel() {
        return requestModel;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getPrincipal() {
        return principal;
    }

    public String getSession() {
        return session;
    }

    public Long getTimeTaken() {
        return timeTaken;
    }
}
