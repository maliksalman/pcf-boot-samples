package com.smalik.hellothere;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @RequestMapping(value = "/payload", method = RequestMethod.GET)
    @ResponseBody public Payload getPayload() {
        return new Payload("ServiceBBB", "Be like the bee!");
    }
}
