package com.assignment.question.model;


import javax.persistence.*;

@Entity
@Table(name = "questionnaire")
public class Questionnaire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String Question;

    public Questionnaire() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public Questionnaire(Long id, String question) {
        this.id = id;
        Question = question;
    }
}
