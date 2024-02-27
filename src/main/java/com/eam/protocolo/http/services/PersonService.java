package com.eam.protocolo.http.services;

import com.eam.protocolo.http.models.entities.Person;

import java.util.List;

public interface PersonService {

    public List<Person> findAll();
    public Person save(Person person);
    public Person findById(Integer id);
    public void delete(Integer id);
    
}
