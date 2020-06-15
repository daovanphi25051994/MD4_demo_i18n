package com.codegym.controller;

import com.codegym.model.Credential;
import com.codegym.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

@Controller
@SessionAttributes("user")
public class LoginController {

    @Autowired
    private MessageSource messageSource;

    @ModelAttribute("user")
    public User setUser(){
        return new User();
    }

    @GetMapping("/login")
    public ModelAndView getLoginForm(@ModelAttribute("credential") Credential credential){
        ModelAndView modelAndView = new  ModelAndView("login");
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("credential") Credential credential, Locale locale){
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("user", new User());
        String message = messageSource.getMessage("login.message", null, locale);
        modelAndView.addObject("message", message);
        return modelAndView;

    }

}