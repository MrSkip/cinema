package com.countrycinema.ua.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final Facebook facebook;

    @Autowired
    public HomeController(Facebook facebook) {
        this.facebook = facebook;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Reference> friends = facebook.friendOperations().getFriends();
        model.addAttribute("friends", friends);
        return "home";
    }

}
