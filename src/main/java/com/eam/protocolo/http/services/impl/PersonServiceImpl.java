package com.eam.protocolo.http.services.impl;

import com.eam.protocolo.http.models.dtos.PersonDTO;
import com.eam.protocolo.http.models.entities.Person;
import com.eam.protocolo.http.repositories.PersonRepository;
import com.eam.protocolo.http.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;
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

    @Override
    public Person factory(PersonDTO personDTO) {
        Person person = new Person();
        System.err.println(personDTO);
        person.setDocumentNumber(personDTO.getDocumentNumber());
        person.setAddress(person.getAddress());
        person.setEmail(personDTO.getEmail());
        person.setName(personDTO.getName());
        person.setPhoneNumber(personDTO.getPhoneNumber());
        return save(person);
    }
}
