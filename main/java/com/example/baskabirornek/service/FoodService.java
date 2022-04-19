package com.example.baskabirornek.service;

import com.example.baskabirornek.entity.Food;
import com.example.baskabirornek.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository repository;

    public List<Food> getAllShops(){
        List<Food> food_list =  (List<Food>)repository.findAll();
        return food_list;
    }

    public List<Food> getByKeyword(String keyword){
        return repository.findByKeyword(keyword);
    }

}
