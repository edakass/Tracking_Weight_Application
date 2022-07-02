package com.example.baskabirornek.repository;

import com.example.baskabirornek.entity.Motivation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotivationRepository extends JpaRepository<Motivation,Integer> {
}
