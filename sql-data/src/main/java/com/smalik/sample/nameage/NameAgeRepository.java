package com.smalik.sample.nameage;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface NameAgeRepository extends CrudRepository<NameAgeBean, Long> {

	List<NameAgeBean> findByName(String name);
	List<NameAgeBean> findByAgeLessThan(int age);
	List<NameAgeBean> findByAgeGreaterThan(int age);

}
