package com.example.baskabirornek.controller;

import com.example.baskabirornek.entity.Food;
import com.example.baskabirornek.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class FoodController {

    @Autowired
    private FoodService service;
    @RequestMapping("/food")
    public String home(Food food, Model model, String keyword) {
        if(keyword!=null) {
            List<Food> food_list = service.getByKeyword(keyword);
            model.addAttribute("food_list", food_list);
        }else {
            List<Food> food_list = service.getAllShops();
            model.addAttribute("food_list", food_list);}
        return "food";
    }
}
