package com.riad8321.flashcash.controller;

import com.riad8321.flashcash.service.UserService;
import com.riad8321.flashcash.service.form.SignUpForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/signup")
    public ModelAndView showRegisterForm() {
        return new ModelAndView("signup", "signUpForm", new SignUpForm());
    }

    @PostMapping(path="/signup")
    public ModelAndView precessRequest(@ModelAttribute("signUpForm") SignUpForm form) {
       System.out.println(form.toString());
       userService.registration(form);
       return new ModelAndView("signin");
    }


    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
