package com.example.baskabirornek.repository;

import com.example.baskabirornek.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food,Integer> {

    @Query(value = "select * from food f where f.food_name like %:keyword% or f.food_calorie like %:keyword%", nativeQuery = true)
    List<Food> findByKeyword(@Param("keyword") String keyword);


}
