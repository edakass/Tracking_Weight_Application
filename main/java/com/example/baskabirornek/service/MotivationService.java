package com.example.baskabirornek.service;

import com.example.baskabirornek.entity.Motivation;
import com.example.baskabirornek.repository.MotivationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotivationService {

    @Autowired
    private MotivationRepository motivationRepository;

    public List<Motivation> getAllMotivation(){
        List<Motivation> motivation_list=(List<Motivation>)motivationRepository.findAll();
        return  motivation_list;
    }

    public  Motivation get(int id){
        return  motivationRepository.findById(id).get();
    }

}
