package com.smalik.sample.learnmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class BeanController {

	/* Submit bean as request params with a GET operation */
	/* example:
	 *    curl -X GET "http://localhost:8080/bean/params?name=salman&val=40" --silent | jq .
	 */
	@RequestMapping(value="/bean/params", method=RequestMethod.GET)
	@ResponseBody
	public Bean beanRequestWithParams(@Valid Bean bean) {
		bean.setVal(bean.getVal()+1);
		return bean;
	}
	
	/* Submit bean as JSON body with a GET operation */
	/* example:
	 *    curl -X GET -H "Content-Type: application/json" "http://localhost:8080/bean/body" -d '{"name":"Salman", "val":40}' --silent | jq .
	 */
	@RequestMapping(value="/bean/body", method=RequestMethod.GET)
	@ResponseBody
	public Bean beanRequestWithBody(@Valid @RequestBody Bean bean) {
		bean.setVal(bean.getVal()+1);
		return bean;
	}
}
