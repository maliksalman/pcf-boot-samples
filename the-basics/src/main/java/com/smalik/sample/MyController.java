package com.smalik.sample;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    private static Logger LOGGER = LoggerFactory.getLogger(MyController.class);

    @Value("${big.secret:unknown}")
    private String bigSecret;

    @Autowired
    private MessageService messageService;

    @Autowired
    private DelayConfiguration delayConfiguration;

    @RequestMapping(value="/myinfo", method=RequestMethod.GET)
    @ResponseBody public Map<String, String> getMessage() throws InterruptedException {

    	HashMap<String, String> map = new HashMap<>();
    	map.put("message", messageService.getMessage());
    	map.put("secret", bigSecret);

    	// add some artificial delay
    	if (delayConfiguration.isDelayEnabled()) {

    	    int delay = delayConfiguration.isDelayRandomized()
                    ? new Random().nextInt(delayConfiguration.getDelayMillis())
                    : delayConfiguration.getDelayMillis();
    	    Thread.sleep(delay);

    	    LOGGER.info("Getting info: DelayMillis=" + delay);
        } else {
    	    LOGGER.info("Getting info");
        }

        return map;
    }
}
