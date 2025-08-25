package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final PersonService service;

    @GetMapping
    public String index(Model model) {
        List<Person> persons = this.service.findAll();
        model.addAttribute("persons", persons);
        model.addAttribute("form", new Person());
        return "index";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute Person person, BindingResult result) {
        System.out.println(result);
        if (result.hasErrors()) {
            return "index";
        }

        this.service.create(person);
        return "redirect:/person";
    }
}
