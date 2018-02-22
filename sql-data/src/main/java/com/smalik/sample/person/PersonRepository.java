package com.smalik.sample.person;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {

	List<Person> findByName(String name);
	List<Person> findByAgeLessThan(int age);
	List<Person> findByAgeGreaterThan(int age);

}
