package com.example.superhero3.Repository;
import com.example.superhero3.Model.Superhero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class SuperheroRepository {

    public void addSuperhero(String heroName, String Name, String power, int age, double strength)
    {
        superheroes.add(new Superhero(heroName, Name, power, age, strength));
    }

    private ArrayList<Superhero> superheroes = new ArrayList<>();


    public SuperheroRepository(){
        addSuperhero("Spidermand", "Peter Parker", "Web shooter", 17, 99.9);
        addSuperhero("Batman", "Bruce Wayne", "Rich", 40, 20.5);
        addSuperhero("Thanos", "Thanos", "stones", 800, 100);
    }

    public ArrayList<Superhero> getSuperheroes()
    {
        return superheroes;
    }

    public void removeSuperhero(String name)
    {
        for (Superhero s : superheroes) {
            if (s.getHeroName().toLowerCase().contains(name.toLowerCase())) {
                superheroes.remove(s);
            }
        }
    }

    public ArrayList<Superhero> searchSuperHeroes(String name)
    {
        ArrayList<Superhero> searchedSuperheroes = new ArrayList<>();

        for (Superhero superhero : superheroes) {
            if (superhero.getHeroName().toLowerCase().contains(name.toLowerCase())) {
                searchedSuperheroes.add(superhero);
            }
        }
        return searchedSuperheroes;
    }
}
