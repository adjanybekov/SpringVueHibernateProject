package com.example.demo2.model;

import javax.persistence.*;

@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String title;

    @OneToOne
    private Person person;

    public Topic() {
    }

}
