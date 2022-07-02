package com.example.baskabirornek.controller;

import com.example.baskabirornek.entity.Food;
import com.example.baskabirornek.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import  org.springframework.data.domain.Pageable;
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
            List<Food> food_list = service.getAllFood();
            model.addAttribute("food_list", food_list);}
        return "food";
    }

    @GetMapping("/add_food")
    public String add_food(Model model) {
        model.addAttribute("food", new Food());
        return "add_food";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveFood(@ModelAttribute("food") Food food) {
        service.save(food);
        return "redirect:/food";
    }

    @RequestMapping("/f_edit/{id}")
    public ModelAndView showEditFoodPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("add_food");
       // List<Food> food_list = service.getAllFood();
        Food food=service.get((int) id);
        mav.addObject("food", food);
        return mav;

    }

    @RequestMapping("/f_delete/{id}")
    public String delete_food(@PathVariable(name = "id") int id, RedirectAttributes attributes) {
        service.delete(id);
        attributes.addFlashAttribute("success","The food has deleted !");
        return "food";
    }

    @RequestMapping("/admin_food")
    public String getFoodPage() {
        return "admin_food";
    }

}
