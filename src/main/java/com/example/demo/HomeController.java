package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    ActorRepository actorRepository;

    @RequestMapping("/")
    public String index(Model model){
        Actor ac=new Actor();
        ac.setName("Sandra Bullock");
        ac.setRealname("Sandra Mae Bullowski");

        Movie mov=new Movie();
        mov.setTitle("Emoji Movie");
        mov.setYear(2017);
        mov.setDescription("About Emojis...");

        Set<Movie> movies=new HashSet<Movie>();
        movies.add(mov);

        ac.setMovies(movies);

        actorRepository.save(ac);

        model.addAttribute("actors", actorRepository.findAll());
        return "index";
    }
}
