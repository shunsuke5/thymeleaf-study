package com.example.demo.repository;

import com.example.demo.data.person.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {

    private List<Person> persons = new ArrayList<>();

    public List<Person> findAll() {
        return this.persons;
    }

    public Person create(Person person) {
        person.setId(this.persons.size());
        this.persons.add(person);
        return person;
    }
}
