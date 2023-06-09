package com.example.car_store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping({"", "/"})
    public String index() {
        return "index";
    }

    @RequestMapping ("/login")
    public String login(@PathVariable String login){
        return "login";
    }

    @RequestMapping("/login-error") // Чтобы пользователь попад на 404-page
    public String loginError(Model model){
        model.addAttribute("loginError", true);
        return "login";
    }
}
