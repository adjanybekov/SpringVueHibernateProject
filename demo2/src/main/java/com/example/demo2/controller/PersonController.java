package com.example.demo2.controller;

import com.example.demo2.model.Person;
import com.example.demo2.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/persons/v1")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST
    )
    public void insert(@RequestBody Person person){
        personService.insertPerson(person);
    }

    @RequestMapping(
            produces= MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET
    )
    public List<Person> getAllPersons(){
        return personService.getAllPersons();
    }


}
