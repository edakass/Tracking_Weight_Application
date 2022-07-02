package com.example.baskabirornek.entity;

import javax.persistence.*;

@Entity
@Table(name = "exercises")
public class Exercises {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "url")
    private String url;

    public Exercises() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Exercises(int id, String title, String url) {
        this.id = id;
        this.title = title;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Exercises{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
