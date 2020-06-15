package com.codegym.controller;

import com.codegym.model.Credential;
import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("user")
public class LoginController {

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
    public ModelAndView login(@ModelAttribute("credential") Credential credential){
        ModelAndView modelAndView = new ModelAndView("result");
        User user = new User(credential.getUsername());
        modelAndView.addObject("user", user);
        return modelAndView;

    }

}