package com.example.superhero3.Services;
import com.example.superhero3.Model.Superhero;
import com.example.superhero3.Repositories.SuperheroRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SuperheroService {

    private SuperheroRepository superheroRepository;

    public void addSuperhero(String heroName, String Name, String power, int age, double strength) {
        superheroRepository.addSuperhero(heroName, Name, power, age, strength);
    }

    public SuperheroService(){
        superheroRepository = new SuperheroRepository();
    }

    public ArrayList<Superhero> getSuperheroes(){
        return superheroRepository.getSuperheroes();
    }

    public ArrayList<Superhero> searchSuperHero(String name){
        return superheroRepository.searchSuperHeroes(name);
    }

    public void removeSuperhero(String name){
        superheroRepository.removeSuperhero(name);
    }

}
