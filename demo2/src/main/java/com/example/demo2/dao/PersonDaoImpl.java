package com.example.demo2.dao;

import com.example.demo2.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Repository("dao")
public class PersonDaoImpl implements PersonDao {

    private final HashMap<UUID,Person> database;

    public PersonDaoImpl() {
        this.database = new HashMap<>();
        UUID id = UUID.randomUUID();
        this.database.put(id,new Person(id,"Osman","Pasa",22));
    }

    @Override
    public int insertPerson(Person person) {
        UUID id = person.getId()==null?UUID.randomUUID():person.getId();
        person.setId(id);
        database.put(id,person);
        return 1;
    }

    @Override
    public int updatePerson(Person person) {
        return 1;
    }

    @Override
    public Person getPersonById(Person person) {
        return null;
    }

    public List<Person> getAllPersons() {
        return new ArrayList<>(database.values());
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }
}
