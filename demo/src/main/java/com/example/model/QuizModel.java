package com.example.model;

import java.util.List;

public class QuizModel {
	
	
	private Integer id;
	private String quizName;
	private List<QuestionModel> questions;
	
	
	public QuizModel() {
		
	}
	
	public QuizModel(Integer id, String quizName, List<QuestionModel> questions) {
		super();
		this.id = id;
		this.quizName = quizName;
		this.questions = questions;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getQuizName() {
		return quizName;
	}
	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}
	public List<QuestionModel> getQuestions() {
		return questions;
	}
	public void setQuestions(List<QuestionModel> questions) {
		this.questions = questions;
	}
	
	

}
