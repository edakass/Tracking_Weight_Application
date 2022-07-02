package com.example.baskabirornek.controller;

import com.example.baskabirornek.entity.User;
import com.example.baskabirornek.entity.Weight;
import com.example.baskabirornek.service.AuthenticationService;
import com.example.baskabirornek.service.UserServiceImpl;
import com.example.baskabirornek.service.WeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class WeightController {

    @Autowired
    private WeightService service;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private AuthenticationService authenticationService;

  @GetMapping("/data")
    public String  getWeight(Model model){
        long id=authenticationService.getCurrentUId();
        List<Weight> listWeight=service.findByUserId(id);
        model.addAttribute("listWeight",listWeight);
        model.addAttribute("weight",new Weight());
        return "data";
    }

    @PostMapping("/data")
    public  String add(Model model, Authentication authentication){
        long id=authenticationService.getCurrentUId();
        List<Weight> listWeight=service.findByUserId(id);
        model.addAttribute("listWeight",listWeight);
        model.addAttribute("weight",new Weight());
        return "data";
    }

    @GetMapping(value = {"/","/index"}) //model in yanına path variable yapabilirsin
    public String listIndex(Model model){
        long id=authenticationService.getCurrentUId();
        List<Weight> listWeight=service.findByUserId(id);
        model.addAttribute("listWeight",listWeight);
        return "index";
    }

    @RequestMapping(value = "/saveWeight")
    public  String index(@ModelAttribute("weight") Weight weight){
        User user=userService.getCurrentUser();
        weight.setUser(user);
        service.save(weight);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditWeightPage(@PathVariable(name = "id") float id){
        ModelAndView mav=new ModelAndView("data");
        Weight weight=service.get((long) id);
        mav.addObject("weight",weight);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public  String deleteWeight(@PathVariable(name = "id") float id, RedirectAttributes attributes){
        service.delete((long) id);
        attributes.addFlashAttribute("success","The weight has deleted !");
        return  "redirect:/";
    }
}
