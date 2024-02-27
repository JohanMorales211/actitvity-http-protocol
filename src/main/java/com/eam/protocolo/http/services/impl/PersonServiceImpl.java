package com.eam.protocolo.http.services.impl;

import com.eam.protocolo.http.models.entities.Person;
import com.eam.protocolo.http.repositories.PersonRepository;
import com.eam.protocolo.http.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository
    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person findById(Integer id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        personRepository.deleteById(id);
    }
}
