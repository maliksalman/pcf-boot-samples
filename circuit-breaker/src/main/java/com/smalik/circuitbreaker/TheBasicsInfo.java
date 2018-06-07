package com.smalik.circuitbreaker;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TheBasicsInfo {

    private String message;
    private String secret;

    @JsonCreator
    public TheBasicsInfo(
            @JsonProperty("message") String message,
            @JsonProperty("secret") String secret) {
        this.message = message;
        this.secret = secret;
    }

    public String getMessage() {
        return message;
    }

    public String getSecret() {
        return secret;
    }
}
