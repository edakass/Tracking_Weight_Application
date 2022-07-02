package com.example.baskabirornek.service;

import com.example.baskabirornek.entity.Exercises;
import com.example.baskabirornek.repository.ExercisesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExercisesService {

    @Autowired
    private ExercisesRepository exercisesRepository;

    public List<Exercises> getAllExercises(){
        List<Exercises> exercises_list=(List<Exercises>)exercisesRepository.findAll();
        return  exercises_list;
    }

    public  Exercises get(int id){
        return  exercisesRepository.findById(id).get();
    }

    public  void save(Exercises exercises){
        exercisesRepository.save(exercises);
    }

    public  void  delete(int id){
        exercisesRepository.deleteById(id);
    }

    public  List<Exercises> getByVideoKeyword(String keyword){
        return  exercisesRepository.findByKeyword(keyword);
    }
}
