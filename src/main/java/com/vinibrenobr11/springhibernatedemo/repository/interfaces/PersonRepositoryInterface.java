package com.vinibrenobr11.springhibernatedemo.repository.interfaces;

import com.vinibrenobr11.springhibernatedemo.models.Person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepositoryInterface extends JpaRepository<Person, Long> {}
