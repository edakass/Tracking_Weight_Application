package com.example.baskabirornek.service;

import com.example.baskabirornek.entity.Food;
import com.example.baskabirornek.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import  org.springframework.data.domain.Pageable;


import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository repository;

    public List<Food> getAllFood(){
        List<Food> food_list = (List<Food>)repository.findAll();
        return food_list;
    }

    public Food get(int id){
        return  repository.findById(id).get();
    }

    public List<Food> getByKeyword(String keyword) {
        return repository.findByKeyword(keyword);
    }

    public void save(Food food) {
        repository.save(food);
    }


    public void delete(int id) {

        repository.deleteById(id);
    }

}
