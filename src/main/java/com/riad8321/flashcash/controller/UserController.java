package com.riad8321.flashcash.controller;


import com.riad8321.flashcash.model.User;
import com.riad8321.flashcash.service.SessionService;
import com.riad8321.flashcash.service.UserService;
import com.riad8321.flashcash.service.form.AddCashForm;
import com.riad8321.flashcash.service.form.AddIbanForm;
import com.riad8321.flashcash.service.form.SignUpForm;
import com.riad8321.flashcash.service.form.WithdrawCashForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {
    private final UserService userService;
    private final SessionService sessionService;

    public UserController(UserService userService, SessionService sessionService) {
        this.userService = userService;
        this.sessionService = sessionService;
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

    @GetMapping("profile")
    public ModelAndView profile(Model model) {
        User user = sessionService.sessionUser();
        model.addAttribute("user", user);
        return new ModelAndView("profile");
    }


    @GetMapping("/")
    public ModelAndView index(Model model) {
        User user = sessionService.sessionUser();
        model.addAttribute("user", user);
        return new ModelAndView("index");
    }

    @GetMapping("/add-iban")
    public ModelAndView showIbanRegisterForm(Model model) {
        User user = sessionService.sessionUser();
        model.addAttribute("user", user);
        return new ModelAndView("add-iban", "AddIbanForm", new  AddIbanForm());
    }

    @PostMapping(path="/add-iban")
    public ModelAndView addIbanRegisterForm(Model model, @ModelAttribute("addIbanForm") AddIbanForm form) {
        User user = sessionService.sessionUser();
        userService.ibanRegistration(form);
        model.addAttribute("user", user);
        return new ModelAndView("add-iban");
    }

    @GetMapping("/add-cash")
    public ModelAndView showAddCashForm(Model model) {
        User user = sessionService.sessionUser();
        model.addAttribute("user", user);
        return new ModelAndView("add-cash", "AddIbanForm", new  AddIbanForm());
    }

    @PostMapping(path="/add-cash")
    public ModelAndView showAddCashForm(Model model, @ModelAttribute("addCashForm") AddCashForm form) {
        User user = sessionService.sessionUser();
        userService.addCash(form);
        model.addAttribute("user", user);
        return new ModelAndView("add-cash");
    }

    @GetMapping("/withdraw")
    public ModelAndView showWithdrawCash(Model model) {
        User user = sessionService.sessionUser();
        model.addAttribute("user", user);
        return new ModelAndView("withdraw", "WithdrawCashForm", new WithdrawCashForm());
    }

    @PostMapping(path="/withdraw")
    public ModelAndView showWithdrawCashForm(Model model, @ModelAttribute("withdrawCashForm") WithdrawCashForm form) {
        User user = sessionService.sessionUser();
        userService.withdrawCash(form);
        model.addAttribute("user", user);
        return new ModelAndView("withdraw");
    }

    @GetMapping(path="/transfers")
    public ModelAndView transfers(Model model) {
        User user = sessionService.sessionUser();
        model.addAttribute("user", user);
        return new ModelAndView("transfers");
    }

}













