package com.example.superhero3.Controller;
import com.example.superhero3.Model.Superhero;
import com.example.superhero3.Services.SuperheroService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("superheroes")
public class SuperheroController {

    private SuperheroService superheroService;

    public SuperheroController() {
        superheroService = new SuperheroService();
    }

    @GetMapping("List")
    public ResponseEntity<List<Superhero>> listSuperheroes() {
        List superheroes = superheroService.getSuperheroes();

        return new ResponseEntity<>(superheroes, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<List<Superhero>> getSuperhero(@PathVariable String id) {
        List foundSuperhero = superheroService.searchSuperHero(id);

        return new ResponseEntity<>(foundSuperhero, HttpStatus.OK);
    }

    @GetMapping("generate")
    public ResponseEntity<List<Superhero>> createSuperhero() {
        superheroService.addSuperhero("Spiderman", "Peter Parker", "Web shooter", 17, 99.9);
        superheroService.addSuperhero("Batman", "Bruce Wayne", "Rich", 40, 20.5);
        superheroService.addSuperhero("Thanos", "Thanos", "stones", 800, 100);

        return new ResponseEntity<>(superheroService.getSuperheroes(), HttpStatus.OK);
    }

    @GetMapping("editor")
    public ResponseEntity<List<Superhero>> editSuperhero() {
        return new ResponseEntity<>(superheroService.getSuperheroes(), HttpStatus.OK);
    }

    @GetMapping("delete/{id}")
    public ResponseEntity<String> deleteSuperhero(@PathVariable String id) {
        superheroService.removeSuperhero(id);

        return new ResponseEntity<>(id + "got removed", HttpStatus.OK);
    }


    @RequestMapping("")
    public ResponseEntity<String> htmlSuperhero(@RequestParam String format) {
        HttpHeaders header = new HttpHeaders();
        header.set("content-type", "text/html");
        StringBuilder sb = new StringBuilder();

        if (format != null && format.equals("html")) {
            for (Superhero s : superheroService.getSuperheroes()) {
                sb.append("<html><body><h1>");
                sb.append(s);
                sb.append("</h1></body></html>");
            }
            return new ResponseEntity<>(sb.toString(), header, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
