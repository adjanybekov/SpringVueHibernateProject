package com.example.demo2.controller;

import com.example.demo2.TopicRepository;
import com.example.demo2.dto.CreateTopicDTO;
import com.example.demo2.model.Person;
import com.example.demo2.model.Topic;
import com.example.demo2.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/persons/v1")
public class PersonController {

    private final PersonService personService;
    private final TopicRepository topicRepository;

    @Autowired
    public PersonController(PersonService personService, TopicRepository topicRepository) {
        this.personService = personService;
        this.topicRepository = topicRepository;
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
    public Iterable<Person> getAllPersons(){
        return personService.getAllPersons();
    }

    @PostMapping
    public void createTopic(CreateTopicDTO topicDTO) {
        Topic t = new Topic();
        topicRepository.save(t);
    }
}