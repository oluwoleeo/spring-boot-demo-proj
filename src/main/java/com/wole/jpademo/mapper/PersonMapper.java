package com.wole.jpademo.mapper;

import com.wole.jpademo.dto.PersonDTO;
import com.wole.jpademo.entity.Person;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class PersonMapper {
    public static Person mapToPerson(PersonDTO personDTO){
        Person person = new Person(
                personDTO.getFirstName(),
                personDTO.getMiddleName(),
                personDTO.getLastName(),
                personDTO.getAge(),
                personDTO.getDateOfBirth(),
                ZonedDateTime.now(),
                null,
                null
        );

        return person;
    }

    public static PersonDTO mapToPersonDTO(Person person){
        PersonDTO personDTO = new PersonDTO(
                person.getFirstName(),
                person.getMiddleName(),
                person.getLastName(),
                person.getAge(),
                person.getDateOfBirth()
        );
        personDTO.setId(person.getId());

        return personDTO;
    }

    public static List<PersonDTO> mapToPersonDTOs(List<Person> persons){
        List<PersonDTO> personsDTOs = new ArrayList<>();
        persons.forEach(p -> personsDTOs.add(mapToPersonDTO(p)));;

        return personsDTOs;
    }
}
