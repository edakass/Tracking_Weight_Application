package com.example.baskabirornek.controller;

import com.example.baskabirornek.entity.Exercises;
import com.example.baskabirornek.repository.ExercisesRepository;
import com.example.baskabirornek.service.ExercisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ExercisesController {

    @Autowired
    private ExercisesService exercisesService;

    @Autowired
    private ExercisesRepository exercisesRepository;

    @RequestMapping("/exercise")
    public String videoHomePage(Exercises exercises, Model model, String keyword){
        if(keyword!=null) {
            List<Exercises> exercises_list = exercisesService.getByVideoKeyword(keyword);
            model.addAttribute("exercises_list", exercises_list);
        }else {
            List<Exercises> exercises_list = exercisesService.getAllExercises();
            model.addAttribute("exercises_list", exercises_list);}
        return "exercise";
    }
    @GetMapping("/add_exercises")
    public  String add_exercises(Model model){
        model.addAttribute("exercises",new Exercises());
        return "add_exercises";
    }
    @RequestMapping(value = "/saveExercises", method = RequestMethod.POST)
    public  String saveExercises(@ModelAttribute("exercises") Exercises exercises){
       exercisesService.save(exercises);
        return "redirect:/exercise";
    }
    @RequestMapping("/ex_edit/{id}")
    public ModelAndView showEditExercisesPage(@PathVariable(name="id") int id){
        ModelAndView mav=new ModelAndView("add_exercises");
        Exercises exercises=exercisesService.get((int) id);
        mav.addObject("exercises",exercises);
        return  mav;

    }

    @RequestMapping("/ex_delete/{id}")
    public  String delete_exercises(@PathVariable(name="id") int id, RedirectAttributes attributes){
        exercisesService.delete(id);
        attributes.addFlashAttribute("success","The exercises has deleted !");
        return "exercise";
    }

}
