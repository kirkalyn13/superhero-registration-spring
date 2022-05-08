package com.example.kirky.superheroregistration.repositories;

import com.example.kirky.superheroregistration.model.Superhero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SuperheroRepository extends JpaRepository<Superhero, Long> {
    Optional<Superhero> findStudentByAlias(String alias);
}
