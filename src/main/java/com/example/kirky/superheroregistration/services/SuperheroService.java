package com.example.kirky.superheroregistration.services;

import com.example.kirky.superheroregistration.model.Superhero;
import com.example.kirky.superheroregistration.repositories.SuperheroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperheroService {
    private final SuperheroRepository superheroRepository;

    @Autowired
    public SuperheroService(SuperheroRepository superheroRepository) {
        this.superheroRepository = superheroRepository;
    }

    public List<Superhero> getRegistered(){
        return superheroRepository.findAll();
    }
}
