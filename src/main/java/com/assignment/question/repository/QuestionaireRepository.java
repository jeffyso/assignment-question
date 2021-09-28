package com.assignment.question.repository;

import com.assignment.question.model.Question;
import com.assignment.question.model.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionaireRepository extends JpaRepository<Questionnaire,Long> {
}
