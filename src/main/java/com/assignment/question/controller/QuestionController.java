package com.assignment.question.controller;

import com.assignment.question.exception.ResourceNotFoundException;
import com.assignment.question.model.Answer;
import com.assignment.question.model.Question;
import com.assignment.question.model.Questionnaire;
import com.assignment.question.repository.QuestionRepository;
import com.assignment.question.repository.QuestionnaireRepository;
import com.assignment.question.repository.AnswerRepository;
import com.fasterxml.jackson.core.io.JsonStringEncoder;
import com.fasterxml.jackson.databind.ObjectMapper;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    List<String> questionnaire = null;

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

    @PostMapping("/questionnaire")
    public ResponseEntity createQuestionnaire(){
      List questions = questionRepository.findAll();
      List answer = answerRepository.findAll();
        questionnaire = new ArrayList(questions);
        questionnaire.addAll(answer);
      return ResponseEntity.ok().body(questionnaire);
    }

    @GetMapping("/questionnaire")
    public ResponseEntity getAllQuestionnaire(){
        return ResponseEntity.ok().body(questionnaire);
    }

    @PostMapping("/answer")
    public Answer answer(@Valid @RequestBody Answer answer ) throws ResourceNotFoundException{
        Long questionId = answer.getQuestionId();
        String typeAns = answer.getTypeAns();
        if(!typeAns.equalsIgnoreCase("written") && !typeAns.equalsIgnoreCase("multiple")){
            throw new ResourceNotFoundException("type answer is wrong Please enter type `written` or `multiple` ");
        }
        Question question = questionRepository.findById(questionId).orElseThrow(() -> new ResourceNotFoundException("QuestionId Not Found"));
        return answerRepository.save(answer);
    }

    @GetMapping("/answer")
    public List<Answer> Answer(){
        return answerRepository.findAll();
    }

    @PostMapping("/generate-csv")
    public ResponseEntity generateCSV(){
        try{
            PrintWriter pw = new PrintWriter(new File("/Users/admin/workspace/assignment-question/src/assets/Book.csv"));
            StringBuilder sb = new StringBuilder();
            List<String> questionnaireList = questionnaire;
//            String result = questionnaireList.stream()
//                    .map(n -> String.valueOf(n))
//                    .collect(Collectors.joining("-", "{", "}"));
            System.out.println(questionnaireList);
            sb.append(questionnaireList);
            pw.write(sb.toString());
            pw.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().body(questionnaire);
    }
}
