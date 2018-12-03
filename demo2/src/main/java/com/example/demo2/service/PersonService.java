package com.example.demo2.service;

import com.example.demo2.dao.PersonDao;
import com.example.demo2.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("dao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int insertPerson(Person person){
        return personDao.insertPerson(person);
    }
    public List<Person> getAllPersons(){
        return personDao.getAllPersons();
    }
//    int updatePerson(Person person);
//    Person getPersonById(Person person);
//    List<Person> getAllPersons(Person person);
//    int deletePersonById(UUID id);
}
