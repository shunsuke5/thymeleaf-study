package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class TopController {

    @GetMapping
    public String index(Model model) {
        List<String> fruits = List.of("apple", "grape", "orange");
        boolean isHungry = true;
        String name = "shunsuke";
        List<String> games = List.of("pokemon", "mario", "zerda");
        List<Animal> animals = List.of(
                new Animal("rion", List.of(new Favorite("meet"), new Favorite("bone"))),
                new Animal("rabbit", List.of(new Favorite("grass"), new Favorite("bean")))
        );
        boolean isPremium = true;

        model.addAttribute("localDate", LocalDate.now());
        model.addAttribute("str", "ababa");

        model.addAttribute("fruits", fruits);
        model.addAttribute("isHungry", isHungry);
        model.addAttribute("name", name);
        model.addAttribute("games", games);
        model.addAttribute("animals", animals);
        model.addAttribute("isPremium", isPremium);

        return "index";
    }

    @GetMapping("/a")
    public String a() {
        return "/fragments/a";
    }
}

record Animal(String name, List<Favorite> favorites) {};
record Favorite(String name) {};