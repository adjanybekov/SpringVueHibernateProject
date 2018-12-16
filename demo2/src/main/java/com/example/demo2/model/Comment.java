package com.example.demo2.model;

import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue
    private int id;
    private String comment;
    @OneToOne
    private Person person;
    @OneToOne
    private Topic topic;

    public Comment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
