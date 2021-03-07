package com.vinibrenobr11.springhibernatedemo.apis;

import com.vinibrenobr11.springhibernatedemo.models.Person;
import com.vinibrenobr11.springhibernatedemo.repository.interfaces.PersonRepositoryInterface;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;

@Getter
@RestController
@RequestMapping(value="/demo", produces = { MediaType.APPLICATION_JSON_VALUE })
public class DemoApi {

    @Autowired
    PersonRepositoryInterface personRepo;
    
    @GetMapping("/get")
    public Iterable<Person> getHelloWorld() {
        return personRepo.findAll();
    }

    @GetMapping("/teste")
    public String teste() {
        return "Hello World";
    }
}
