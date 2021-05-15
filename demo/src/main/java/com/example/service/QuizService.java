package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.model.AnswerModel;
import com.example.model.QuestionModel;
import com.example.model.QuizModel;

@Component
public class QuizService {
	
	private static List<QuizModel> quizDb = new ArrayList();
	static Integer maxQuizId=0;
	static Integer maxQsnId=0;
	
	public QuizService() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		List<String> anss = new ArrayList();
		anss.add("delhi");
		anss.add("kolkata");
		anss.add("mumbai");
		anss.add("chennai");
		QuestionModel model1 = new QuestionModel(1,"What is the capital of india",anss,"delhi");
		List<String> anss2 = new ArrayList();
		anss2.add("delhi");
		anss2.add("kolkata");
		anss2.add("mumbai");
		anss2.add("chennai");
		QuestionModel model2 = new QuestionModel(2,"What is best city in india",anss2,"mumbai");
		List<String> anss3 = new ArrayList();
		anss3.add("delhi");
		anss3.add("kolkata");
		anss3.add("mumbai");
		anss3.add("chennai");
		QuestionModel model3 = new QuestionModel(1,"What is the cleanest city of india",anss3,"kolkata");
		
		List<QuestionModel> qsns = new ArrayList();
		qsns.add(model1);
		qsns.add(model2);
		qsns.add(model3);
		QuizModel quiz = new QuizModel(1,"city challenge",qsns);
		new QuizService().createQuiz(quiz);
	}
	
	public String createQuiz(QuizModel model) {
		if(validQuiz(model)) {
			model.setId(++maxQuizId);
		 quizDb.add(model);
		 return "Added";
		} else {
			return "Not valid";
		}
	}
	
	boolean validQuiz(QuizModel model) {
		for(QuestionModel qsn : model.getQuestions()) {
			if(!qsn.ifValid())
				return false;
			if(qsn.getId() == null)
				qsn.setId(++maxQsnId);
		}
		return true;
	}
	
	public List<QuizModel> getAllQuiz() {
		return quizDb;
	}
	
	public QuizModel getQuiz(String quizName) {
		for(QuizModel quiz  : quizDb) {
		if(quiz.getQuizName().equals(quizName))
			return quiz;
		}
		return null;
	}
	
	public String submitQuiz(String quizName, List<AnswerModel> answers) {
		List<QuestionModel> questions =null;
		for(QuizModel quiz  : quizDb) {
			if(quiz.getQuizName().equals(quizName)) {
				questions = quiz.getQuestions();
				break;
			}
		}
		if(questions != null) {
			Map<Integer,String> answerMap = answers.stream()
					.collect(Collectors.toMap(AnswerModel::getQsnId, AnswerModel::getAnswer));
			int max=0,score=0;
			for(QuestionModel qsn : questions) {
				max++;
				if(answerMap.containsKey(qsn.getId()) || answerMap.get(qsn.getId()).equals(qsn.getAns()))
					score++;
			}
			return score + "/" + max;
		}
		else return "0";
	}

}
