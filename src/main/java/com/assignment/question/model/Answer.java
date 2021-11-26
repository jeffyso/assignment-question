package com.assignment.question.model;

import javax.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String Answer;
    private String typeAns;
    private long questionId;

    public Answer() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    public long getQuestionId() {
        return questionId;
    }

    public String getTypeAns() {
        return typeAns;
    }

    public void setTypeAns(String typeAns) {
        this.typeAns = typeAns;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public Answer(long id, String answer, String typeAns, long questionId) {
        this.id = id;
        Answer = answer;
        this.typeAns = typeAns;
        this.questionId = questionId;
    }
}
