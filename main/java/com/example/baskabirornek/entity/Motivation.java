package com.example.baskabirornek.entity;

import org.springframework.web.servlet.ModelAndView;

import javax.persistence.*;

@Entity
@Table(name = "motivation")
public class Motivation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    private  String motivation_text;

    public Motivation(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMotivation_text() {
        return motivation_text;
    }

    public void setMotivation_text(String motivation_text) {
        this.motivation_text = motivation_text;
    }

    @Override
    public String toString() {
        return "Motivation{" +
                "id=" + id +
                ", motivation_text='" + motivation_text + '\'' +
                '}';
    }
}
