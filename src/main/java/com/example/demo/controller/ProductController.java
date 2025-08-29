package com.example.demo.controller;

import com.example.demo.data.person.form.PersonCreateForm;
import com.example.demo.data.product.form.ProductCreateForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/create")
    public String showForm(Model model) {
        ProductCreateForm form = new ProductCreateForm();
        model.addAttribute("productCreateForm", form);
        return "/products/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute ProductCreateForm productCreateform,
                         BindingResult result,
                         RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors()) {
            return "products/create";
        }

        this.service.create(personCreateform);
        redirectAttributes.addFlashAttribute("message", "作成完了");
        return "redirect:/person";
    }
}
