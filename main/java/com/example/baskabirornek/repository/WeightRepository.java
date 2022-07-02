package com.example.baskabirornek.repository;

import com.example.baskabirornek.entity.Weight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeightRepository extends JpaRepository<Weight,Long> {

  List<Weight> findByUserId(long id);

}
