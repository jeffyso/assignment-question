package com.assignment.question.repository;

import com.assignment.question.model.Answer;
import com.assignment.question.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Long> {

}
