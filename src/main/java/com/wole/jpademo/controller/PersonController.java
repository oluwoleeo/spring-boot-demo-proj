package com.wole.jpademo.controller;

import com.wole.jpademo.dto.PersonDTO;
import com.wole.jpademo.dto.SimpleMessage;
import com.wole.jpademo.entity.Person;
import com.wole.jpademo.mapper.PersonMapper;
import com.wole.jpademo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    // @Value("${random.value}")
    // @Value("${random.long}")
    // @Value("${random.uuid}")
    // @Value("${random.int(10)}")
    // @Value("${random.int[25,36]}")
    @Value("${simple.message}")
    private String randomValue;

    @GetMapping("/simplemessage")
    public ResponseEntity<SimpleMessage> getSimpleMessage(){
        SimpleMessage simpleMessage = new SimpleMessage(randomValue);

        return new ResponseEntity<>(simpleMessage, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<PersonDTO> addPerson(@RequestBody PersonDTO personDto){
        PersonDTO returned = personService.savePerson(personDto);
        return new ResponseEntity<>(returned, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable Long id){
        Optional<Person> person = personService.getPersonById(id);

        if (person.isPresent()){
            PersonDTO personDto = PersonMapper.mapToPersonDTO(person.get());
            return new ResponseEntity<>(personDto, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<PersonDTO>> getPersons(){
        List<Person> persons = personService.getPersons();

        List<PersonDTO> personDTOs = PersonMapper.mapToPersonDTOs(persons);

        return new ResponseEntity<>(personDTOs, HttpStatus.OK);
    }
}
