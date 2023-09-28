package com.wole.jpademo.service;

import com.wole.jpademo.dto.PersonDTO;
import com.wole.jpademo.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    PersonDTO savePerson(PersonDTO person);
    Optional<Person> getPersonById(Long id);
    List<Person> getPersons();
}
