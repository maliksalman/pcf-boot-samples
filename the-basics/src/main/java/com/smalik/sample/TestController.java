package com.smalik.sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test/{value}/something")
    public String getPathVariable(@PathVariable("value") String value) {
        return value;
    }

    @GetMapping("/test/something")
    public String getSomething() {
        return "something";
    }
}
