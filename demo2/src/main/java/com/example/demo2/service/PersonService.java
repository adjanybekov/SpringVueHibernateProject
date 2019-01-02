package com.example.demo2.service;

import com.example.demo2.PersonRepository;
import com.example.demo2.TopicRepository;
import com.example.demo2.model.Person;
import com.example.demo2.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonRepository personDao;
    private final TopicRepository topicRepository;

    @Autowired
    public PersonService( PersonRepository personDao,  TopicRepository topicRepository) {
        this.personDao = personDao;
        this.topicRepository  = topicRepository;
    }

    public Person insertPerson(Person person){
        return personDao.save(person);
    }
    public Iterable<Person> getAllPersons(){
        return personDao.findAll();
    }
//    int updatePerson(Person person);
//    Person getPersonById(Person person);
//    List<Person> getAllPersons(Person person);
//    int deletePersonById(UUID id);

    public Topic insertTopic(Topic t) {
        return topicRepository.save(t);
    }
}
