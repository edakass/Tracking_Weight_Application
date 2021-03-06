package com.example.baskabirornek.repository;

import com.example.baskabirornek.entity.Food;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food,Integer> {
    @Query(value = "select * from food f where f.food_name like %:keyword%", nativeQuery = true)
    List<Food> findByKeyword(@Param("keyword") String keyword);
    
   // @Query(value = "select * from food f where f.food_name like %:keyword%", nativeQuery = true)
   // List<Food> findByKeyword(@Param("keyword") String keyword);
    //@Query(value = "select * from food f where f.food_name like %:keyword%", nativeQuery = true)
    //public  List<Food> findAll(String keyword, Pageable pageable);

}
