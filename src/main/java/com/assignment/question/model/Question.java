package com.assignment.question.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    @Column(name = "question")
    private String question;

    public String getQuesionnaire(List question) {
        return quesionnaire;
    }

    public void setQuesionnaire(String quesionnaire) {
        this.quesionnaire = quesionnaire;
    }

    private String quesionnaire;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        this.Id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Question() {
        super();
    }



    public Question(long id, String question) {
        Id = id;
        this.question = question;
    }
}
