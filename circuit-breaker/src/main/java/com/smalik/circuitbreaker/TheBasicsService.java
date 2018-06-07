package com.smalik.circuitbreaker;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.client.RestTemplate;

public class TheBasicsService {

    private RestTemplate restTemplate;

    public TheBasicsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(
            commandKey = "getTheBasicsInfo",
            fallbackMethod = "getTheBasicsInfoFallback")
    public TheBasicsInfo getTheBasicsInfo() {
        return restTemplate.getForEntity("/myinfo", TheBasicsInfo.class).getBody();
    }

    private TheBasicsInfo getTheBasicsInfoFallback() {
        return new TheBasicsInfo("fallback-message", "fallback-secret");
    }

}
