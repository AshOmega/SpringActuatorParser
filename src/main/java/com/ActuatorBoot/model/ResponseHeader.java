package com.ActuatorBoot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseHeader {

    @JsonProperty("Content-Type")
    List<String> contentType;
    @JsonProperty("Transfer-Encoding")
    List<String> transferEncoding;
    List<String> date;

    public ResponseHeader() {
    }

    public ResponseHeader(List<String> contentType, List<String> transferEncoding, List<String> date) {
        this.contentType = contentType;
        this.transferEncoding = transferEncoding;
        this.date = date;
    }

    public List<String> getContentType() {
        return contentType;
    }

    public List<String> gettransferEncoding() {
        return transferEncoding;
    }

    public List<String> getDate() {
        return date;
    }

    public void setContentType(List<String> contentType) {
        this.contentType = contentType;
    }

    public void setTransferEncoding(List<String> transferEncoding) {
        this.transferEncoding = transferEncoding;
    }

    public void setDate(List<String> date) {
        this.date = date;
    }
}
