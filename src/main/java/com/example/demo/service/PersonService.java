package com.example.demo.service;

import com.example.demo.data.person.form.PersonCreateForm;
import com.example.demo.data.person.model.Person;
import com.example.demo.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repository;

    public List<Person> findAll() {
        return this.repository.findAll();
    }

    public Person create(PersonCreateForm form) {
        Person person = Person.builder()
                .name(form.getName())
                .age(form.getAge())
                .build();
        return this.repository.create(person);
    }
}
