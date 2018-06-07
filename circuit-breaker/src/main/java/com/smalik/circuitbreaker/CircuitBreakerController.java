package com.smalik.circuitbreaker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerController {

    private TheBasicsService theBasicsService;

    public CircuitBreakerController(TheBasicsService theBasicsService) {
        this.theBasicsService = theBasicsService;
    }

    @GetMapping("/basicsinfo")
    public TheBasicsInfo getTheBasicsInfo() {
        return theBasicsService.getTheBasicsInfo();
    }
}
