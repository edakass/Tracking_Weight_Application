package com.example.baskabirornek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @GetMapping("/login")
    public  String login(){
        return "login";
    }

   /* @RequestMapping("/motivation")
    public String getMotivationPage() {
        return "motivation";
    }*/

    @RequestMapping("/settings")
    public String getSettingsPage() {
        return "settings";
    }

    @RequestMapping("/main_page")
    public String getPage() {
        return "main_page";
    }


   @RequestMapping("/calculate")
    public String getCalPage() {
        return "calculate";
    }

}
