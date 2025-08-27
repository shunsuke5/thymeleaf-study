package com.example.demo.controller;

import com.example.demo.data.person.form.PersonCreateForm;
import com.example.demo.data.person.model.Person;
import com.example.demo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final PersonService service;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("localDate", LocalDate.now());
        model.addAttribute("str", "ababa");
        List<Person> persons = this.service.findAll();
        model.addAttribute("persons", persons);
        model.addAttribute("personCreateForm", new PersonCreateForm());
        return "index";
    }

    @GetMapping("/{id}")
    public String profile(@PathVariable("id") String id, Model model) {
        model.addAttribute("id", id);
        return "profile";
    }

    @PostMapping
    public String create(@Validated @ModelAttribute PersonCreateForm personCreateform, BindingResult result, Model model) {
        System.out.println(result);
        if (result.hasErrors()) {
            List<Person> persons = this.service.findAll();
            model.addAttribute("persons", persons);
            return "index";
        }

        this.service.create(personCreateform);
        return "redirect:/person";
    }
}
