package com.example.baskabirornek.entity;

import javax.persistence.*;

@Entity
@Table(name = "food")
public class Food{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    private  String food_name;

    private  Integer food_calorie;

    private Integer food_quantity;

    public Food() {

    }

    public Food(Integer id, String food_name, Integer food_calorie, Integer food_quantity) {
        this.id = id;
        this.food_name = food_name;
        this.food_calorie = food_calorie;
        this.food_quantity = food_quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public Integer getFood_calorie() {
        return food_calorie;
    }

    public void setFood_calorie(Integer food_calorie) {
        this.food_calorie = food_calorie;
    }

    public Integer getFood_quantity() {
        return food_quantity;
    }

    public void setFood_quantity(Integer food_quantity) {
        this.food_quantity = food_quantity;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", food_name='" + food_name + '\'' +
                ", food_calorie=" + food_calorie +
                ", food_quantity=" + food_quantity +
                '}';
    }
}
