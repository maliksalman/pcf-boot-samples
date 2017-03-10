package com.smalik.sample.nameage;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CrudController {

	@Autowired
	private NameAgeRepository repo;
	
	/**
	 * Creates a new person, example:
	 * <code>
	 * curl -X POST -H "Content-Type: application/json" "http://localhost:8080/person" -d '{"name":"BruceWayne", "age":35}' --silent | jq .
	 * curl -X POST -H "Content-Type: application/json" "http://localhost:8080/person" -d '{"name":"ClarkKent", "age":25}' --silent | jq .
	 * </code>
	 */
	@RequestMapping(value="/person", method=RequestMethod.POST)
	@ResponseBody
	public NameAgeBean create(@RequestBody @Valid NameAgeBean bean) {
		return repo.save(bean);
	}
	
	/**
	 * Gets a list of all people in the system, example:
	 * <code>
	 * curl -X GET "http://localhost:8080/person" --silent | jq .
	 * </code>
	 */
	@RequestMapping(value="/person", method=RequestMethod.GET)
	@ResponseBody
	public Iterable<NameAgeBean> all() {
		return repo.findAll();
	}
	
	/**
	 * Gets a list of all people in the system younger than the given age, example:
	 * <code>
	 * curl -X GET "http://localhost:8080/person/lt/30" --silent | jq .
	 * </code>
	 */
	@RequestMapping(value="/person/lt/{age}", method=RequestMethod.GET)
	@ResponseBody
	public Iterable<NameAgeBean> lessThan(@PathVariable int age) {
		return repo.findByAgeLessThan(age);
	}

	/**
	 * Gets a list of all people in the system older than the given age, example:
	 * <code>
	 * curl -X GET "http://localhost:8080/person/gt/30" --silent | jq .
	 * </code>
	 */
	@RequestMapping(value="/person/gt/{age}", method=RequestMethod.GET)
	@ResponseBody
	public Iterable<NameAgeBean> greaterThan(@PathVariable int age) {
		return repo.findByAgeGreaterThan(age);
	}

	/**
	 * Gets a list of all people in the system with the given name, example:
	 * <code>
	 * curl -X GET "http://localhost:8080/person/ClarkKent" --silent | jq .
	 * </code>
	 */
	@RequestMapping(value="/person/{name}", method=RequestMethod.GET)
	@ResponseBody
	public Iterable<NameAgeBean> name(@PathVariable String name) {
		return repo.findByName(name);
	}
}
