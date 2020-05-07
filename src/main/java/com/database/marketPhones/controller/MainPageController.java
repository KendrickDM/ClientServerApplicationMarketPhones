package com.database.marketPhones.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    @GetMapping("/main-page")
    public String showMain(){

        return "main-page";
    }
}
