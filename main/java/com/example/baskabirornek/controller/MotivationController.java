package com.example.baskabirornek.controller;

import com.example.baskabirornek.entity.Motivation;
import com.example.baskabirornek.service.MotivationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MotivationController {

    @Autowired
    private MotivationService motivationService;

    @RequestMapping("/motivation")
    public  String homeMotivationPage(Motivation motivation, Model model){
        List<Motivation> motivation_list=motivationService.getAllMotivation();
        model.addAttribute("motivation_list",motivation_list);
        return "motivation";

    }

}
