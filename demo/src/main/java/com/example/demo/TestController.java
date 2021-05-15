package com.example.demo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.model.AnswerModel;
import com.example.model.QuestionModel;
import com.example.model.QuizModel;
import com.example.service.QuizService;



@RestController
public class TestController {
	
	
	QuizService quizService = new QuizService();
	
	@PostMapping("/createQuiz")
	public String createQuiz(@RequestBody QuizModel model) {
		return quizService.createQuiz(model);
	}
	
	@GetMapping(path = "/getAllQuiz") 
	public List<QuizModel> getAllQuiz(){
		return quizService.getAllQuiz();
	}
	@PostMapping(path = "/submitQuiz/{quizName}")
	public String submitQuiz(@PathVariable String quizName, @RequestBody List<AnswerModel> answers) {
		String result = quizService.submitQuiz(quizName, answers);
		return "Your score is : "+result;
	}
	@GetMapping(path = "/getQuiz/{quizName}") 
	public QuizModel getQuiz(@PathVariable String quizName){
		return quizService.getQuiz(quizName);
	}
	
	/*
	 * @PostMapping("/addQuestions/") public String addQuestions(@RequestBody
	 * List<QuestionModel> models) { return quizService.addQuestions(models); }
	 */
	
	/*
	 * @RequestMapping(method = RequestMethod.GET,path = "/home") public String
	 * hello() { return "Hello"; }
	 * 
	 * @GetMapping(path = "/home/name/{name}") public String hello(@PathVariable
	 * String name) { return "Welcome "+name; }
	 * 
	 * @PostMapping(path = "/home/users") public ResponseEntity
	 * createUser(@RequestBody User user) { //User savedUser = service.save(); URI
	 * location; //URI location = ServletUriComponentsBuilder.fromCurrentRequest()
	 * //.path("/{id}").buildAndExpand(savedUser.getId()).toUri(); return
	 * ResponseEntity.created(location).build();
	 * 
	 * }
	 */

}
