package com.example.demo2.model;

import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String comment;
    @OneToOne
    private Person person;
    @OneToOne
    private Topic topic;

    public Comment() {
    }
}
