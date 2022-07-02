package com.example.baskabirornek.entity;

import javax.persistence.*;

@Entity
@Table(name="my_weight")
public class Weight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name="kilogram")
    private  float kilogram;

    private String date;
    /*
    Date hatasından dolayı  olmadığını düşündüm
        @DateTimeFormat(pattern = "dd/MM/yyyy ")
    private Date date;
     */

    public Weight(Long id, float kilogram, String date) {
        this.id = id;
        this.kilogram = kilogram;
        this.date = date;
    }

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    /*
    ALTER TABLE my_weight Modify column kilogram decimal(4,2);

     */
    public Weight() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getKilogram() {
        return kilogram;
    }

    public void setKilogram(float kilogram) {
        this.kilogram = kilogram;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
