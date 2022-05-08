package com.example.kirky.superheroregistration.services;

import com.example.kirky.superheroregistration.model.Superhero;
import com.example.kirky.superheroregistration.repositories.SuperheroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void addRegistered(Superhero superhero) {
        //Check if Alias is already taken.
        Optional<Superhero> superheroOptional = superheroRepository.findStudentByAlias(superhero.getAlias());
        if(superheroOptional.isPresent()){
            throw new IllegalStateException("Alias taken");
        }
        superheroRepository.save(superhero);
        System.out.println("Registered New Enhanced.");
    }
    public void deleteRegistered(Long superheroId) {
        boolean exists = superheroRepository.existsById(superheroId);
        if(!exists){
            throw new IllegalStateException("Enhanced number: " + superheroId + " does not exist.");
        }
        superheroRepository.deleteById(superheroId);
        System.out.println("Removed Enhanced number: " + superheroId);
    }

}
