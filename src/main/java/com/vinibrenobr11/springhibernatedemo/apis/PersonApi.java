package com.vinibrenobr11.springhibernatedemo.apis;

import java.util.List;

import com.vinibrenobr11.springhibernatedemo.models.Person;
import com.vinibrenobr11.springhibernatedemo.repository.interfaces.PersonRepositoryInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/person", produces = { MediaType.APPLICATION_JSON_VALUE })
public class PersonApi {

    @Autowired
    private PersonRepositoryInterface personRepo;
    
    @GetMapping
    public List<Person> getAll() {
        return personRepo.findAll();
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
    public Person persist(Person p) {
        return personRepo.save(p);
    }
}

