package com.example.demo2.dao;

import com.example.demo2.model.Person;

import java.util.List;
import java.util.UUID;


public interface PersonDao {
    int insertPerson(Person person);
    int updatePerson(Person person);
    Person getPersonById(Person person);
    List<Person> getAllPersons();
    int deletePersonById(UUID id);

}
