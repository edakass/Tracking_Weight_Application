package com.example.baskabirornek.service;

import com.example.baskabirornek.entity.Weight;
import com.example.baskabirornek.repository.WeightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeightService {

    @Autowired
    private WeightRepository repo;

    public List<Weight> findByUserId(long id){
        return  repo.findByUserId(id);
    }

    public List<Weight> listAll(){
        return  repo.findAll();
    }

    public void save(Weight weight){
        repo.save(weight);
    }

    public  Weight get(long id){
        return repo.findById(id).get();
    }

    public void delete(long id) {

        repo.deleteById(id);
    }
}
