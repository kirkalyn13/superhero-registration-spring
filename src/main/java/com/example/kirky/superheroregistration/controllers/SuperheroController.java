package com.example.kirky.superheroregistration.controllers;

import com.example.kirky.superheroregistration.model.Superhero;
import com.example.kirky.superheroregistration.services.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/registered")
public class SuperheroController {
    private final SuperheroService superheroService;

    @Autowired
    public SuperheroController(SuperheroService superheroService) {
        this.superheroService = superheroService;
    }

    @GetMapping
    public List<Superhero> getRegistered(){
        return superheroService.getRegistered();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Superhero superhero){
        superheroService.addRegistered(superhero);
        System.out.println("Registered New Enhanced.");
    }
}
