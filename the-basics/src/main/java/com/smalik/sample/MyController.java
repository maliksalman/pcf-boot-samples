package com.smalik.sample;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @Value("${big.secret:unknown}")
    private String bigSecret;

    @Autowired
    private MessageService messageService;

    @RequestMapping(value="/myinfo", method=RequestMethod.GET)
    @ResponseBody public Map<String, String> getMessage() {
    	HashMap<String, String> map = new HashMap<>();
    	map.put("message", messageService.getMessage());
    	map.put("secret", bigSecret);
        return map;
    }
}
