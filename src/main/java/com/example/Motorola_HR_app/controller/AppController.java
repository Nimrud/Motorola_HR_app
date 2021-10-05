package com.example.Motorola_HR_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/")
    public String homepage() {
        return "homepage";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
