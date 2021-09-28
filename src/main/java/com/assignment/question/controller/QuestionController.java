package com.assignment.question.controller;

import com.assignment.question.exception.ResourceNotFoundException;
import com.assignment.question.model.Question;
import com.assignment.question.repository.QuestionRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/questions")
    public List<Question> getAllQuestion(){
        return questionRepository.findAll();
    }

    @PostMapping("/questions")
    public Question createQuestion(@Valid @RequestBody Question question){
        return  questionRepository.save(question);
    }

    @GetMapping("/questions/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable(name = "id") long id) throws ResourceNotFoundException{
         Question question = questionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));
         return ResponseEntity.ok().body(question);
    }

    @PutMapping("/questions/{id}")
    public ResponseEntity updateQuestion(@PathVariable(name = "id") long id , @RequestBody Question questionDetails) throws ResourceNotFoundException {
        Question question = questionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        question.setQuestion(questionDetails.getQuestion());
        questionRepository.save(question);
        return ResponseEntity.ok().body(question);
    }

    @DeleteMapping("/questions/{id}")
    public ResponseEntity deleteQuestion(@PathVariable(name = "id") long id) throws ResourceNotFoundException{
        Question question = questionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        questionRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
