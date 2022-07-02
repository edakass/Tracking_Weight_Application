package com.example.baskabirornek.repository;

import com.example.baskabirornek.entity.Exercises;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExercisesRepository extends JpaRepository<Exercises,Integer> {

    @Query(value = "select * from exercises ex where ex.title like %:keyword%", nativeQuery = true)
    List<Exercises> findByKeyword(@Param("keyword") String keyword);
}
