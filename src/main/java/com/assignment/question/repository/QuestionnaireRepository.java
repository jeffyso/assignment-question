package com.assignment.question.repository;

import com.assignment.question.model.Question;
import com.assignment.question.model.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long>{

}
