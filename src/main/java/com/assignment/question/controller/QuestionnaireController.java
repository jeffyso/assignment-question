package com.assignment.question.controller;

import com.assignment.question.model.Question;
import com.assignment.question.model.Questionnaire;
import com.assignment.question.repository.QuestionRepository;
import com.assignment.question.repository.QuestionaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class QuestionnaireController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionaireRepository questionnaireRepository;

    List questionnaire[];

    @PostMapping("/questionnaire")
    public ResponseEntity createQuestionnaire(Question questionniare){

        List question = questionRepository.findAll();
        questionniare.setQuestion(questionniare.getQuesionnaire(question));
        List quesionnaire = questionnaireRepository.saveAll(question);
        System.out.println(questionnaire);
        return ResponseEntity.ok().body(question);
    }

    @GetMapping("/questionnaire")
    public List<Questionnaire> getAllQuestionaire(){
        System.out.println(questionnaireRepository.findAll());
        return questionnaireRepository.findAll();
    }
}
