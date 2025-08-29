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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

        return "person/index";
    }

    @GetMapping("/{id}")
    public String profile(@PathVariable("id") String id, Model model) {
        model.addAttribute("id", id);
        return "person/profile";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("personCreateForm", new PersonCreateForm());
        return "person/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute PersonCreateForm personCreateform,
                         BindingResult result,
                         RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors()) {
            return "person/create";
        }

        this.service.create(personCreateform);
        redirectAttributes.addFlashAttribute("message", "作成完了");
        return "redirect:/person";
    }
}
