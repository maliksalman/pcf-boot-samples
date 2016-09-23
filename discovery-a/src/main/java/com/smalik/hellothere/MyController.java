package com.smalik.hellothere;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class MyController {

	@RequestMapping(value = "/payload", method = RequestMethod.GET)
	@ResponseBody
	public Payload getPayload() {
		return new Payload("ServiceAAA", "A is my favorite alphabet!");
	}

	@Autowired
	private RestTemplate rest;
	
	@Autowired
	private FloppyStatusMode floppyStatusMode;
	
	@RequestMapping(value = "/payload/b", method = RequestMethod.GET)
	@ResponseBody
	public Payload getPayloadFromB() {
		return rest.getForObject("http://discovery-b/payload", Payload.class);
	}
	
	@RequestMapping(value = "/floppy/{flag}", method = RequestMethod.POST)
	@ResponseBody
	public boolean setFloppyMode(@PathVariable("flag") boolean enabled) {
		floppyStatusMode.setEnabled(enabled);
		return enabled;
	}
}
