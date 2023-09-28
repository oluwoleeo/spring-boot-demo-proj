package com.wole.jpademo.repository;

import com.wole.jpademo.entity.Person;
import org.springframework.data.repository.CrudRepository;


public interface PersonRepository extends CrudRepository<Person, Long> {

}
