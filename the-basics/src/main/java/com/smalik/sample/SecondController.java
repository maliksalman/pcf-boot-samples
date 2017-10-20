package com.smalik.sample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecondController {


	@RequestMapping("/second/{val}/sayhello")
	public @ResponseBody NotTooComplex sayHello(@PathVariable("val") int myVal, @RequestParam(value="name", required=false) String myName) {
		String theName = myName == null ? "Infinity" : myName;
		return new NotTooComplex(myVal, theName);
	}


}
