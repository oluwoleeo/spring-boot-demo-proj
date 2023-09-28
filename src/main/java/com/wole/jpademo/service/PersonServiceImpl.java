package com.wole.jpademo.service;

import com.wole.jpademo.dto.PersonDTO;
import com.wole.jpademo.entity.Person;
import com.wole.jpademo.mapper.PersonMapper;
import com.wole.jpademo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Override
    public PersonDTO savePerson(PersonDTO personDto) {
        Person person = PersonMapper.mapToPerson(personDto);
        Person savedPerson = personRepository.save(person);

        PersonDTO savedPersonDto = PersonMapper.mapToPersonDTO(savedPerson);
        return savedPersonDto;
    }

    @Override
    public Optional<Person> getPersonById(Long id) {
        Optional<Person> person = personRepository.findById(id);
        return person;
    }

    @Override
    public List<Person> getPersons() {
        List<Person> persons = StreamSupport.stream(personRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        // List<Person> persons = StreamSupport.stream(personRepository.findAll().spliterator(), false).toList();

        return persons;
    }
}