package com.riad8321.flashcash.controller;

import com.riad8321.flashcash.service.form.SignUpForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // Ajoutez cette annotation pour indiquer que c'est un contrôleur
public class UserController {
    @GetMapping("/signup")
    public ModelAndView showRegisterForm() {
        return new ModelAndView("signup", "signUpForm", new SignUpForm());
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
