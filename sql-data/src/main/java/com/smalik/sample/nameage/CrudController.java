package com.smalik.sample.nameage;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CrudController {

	@Autowired
	private NameAgeRepository repo;
	
	@RequestMapping(value="/person", method=RequestMethod.POST)
	@ResponseBody
	public NameAgeBean create(@Valid NameAgeBean bean) {
		return repo.save(bean);
	}
	
	@RequestMapping(value="/person", method=RequestMethod.GET)
	@ResponseBody
	public Iterable<NameAgeBean> all() {
		return repo.findAll();
	}
	
	@RequestMapping(value="/person/lt/{age}", method=RequestMethod.GET)
	@ResponseBody
	public Iterable<NameAgeBean> lessThan(@PathVariable int age) {
		return repo.findByAgeLessThan(age);
	}

	@RequestMapping(value="/person/gt/{age}", method=RequestMethod.GET)
	@ResponseBody
	public Iterable<NameAgeBean> greaterThan(@PathVariable int age) {
		return repo.findByAgeGreaterThan(age);
	}

	@RequestMapping(value="/person/{name}", method=RequestMethod.GET)
	@ResponseBody
	public Iterable<NameAgeBean> name(@PathVariable String name) {
		return repo.findByName(name);
	}
}
