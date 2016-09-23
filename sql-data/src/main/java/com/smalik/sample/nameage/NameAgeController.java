package com.smalik.sample.nameage;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NameAgeController {

	/* submit with request params */
	/* example:
	 *    curl -X GET "http://localhost:8080/age/params?name=salman&age=40" --silent | jq .
	 */
	@RequestMapping(value="/age/params", method=RequestMethod.GET)
	@ResponseBody
	public NameAgeBean ageRequestWithParams(@Valid NameAgeBean bean) {
		bean.setAge(bean.getAge()+1);
		return bean;
	}
	
	/* same thing as the params example but you get error codes that make more sense */
	/* example:
	 *    curl -X GET "http://localhost:8080/age/model?name=salman&age=40" --silent | jq .
	 */
	@RequestMapping(value="/age/model", method=RequestMethod.GET)
	@ResponseBody
	public NameAgeBean ageRequestWithModel(@Valid @ModelAttribute("bn") NameAgeBean bean) {
		bean.setAge(bean.getAge()+1);
		return bean;
	}
	
	/* submit with JSON body and set header of "Content-Type: application/json" */
	/* example:
	 *    curl -X GET -H "Content-Type: application/json" "http://localhost:8080/age/body" -d '{"name":"Salman", "age":40}' --silent | jq .
	 */
	@RequestMapping(value="/age/body", method=RequestMethod.GET)
	@ResponseBody
	public NameAgeBean ageRequestWithBody(@Valid @RequestBody NameAgeBean bean) {
		bean.setAge(bean.getAge()+1);
		return bean;
	}
}
