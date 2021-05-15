package com.example.model;

import java.util.List;

public class QuestionModel {
	
	
	private Integer id;
	private String question;
	private List<String> possibleAns;
	private String ans;
	
	public QuestionModel() {
		
	}
	
	public boolean ifValid() {
		for(String pAns : possibleAns) {
			if(pAns.equals(ans))
				return true;
		}
		return false;
	}
	
	public QuestionModel(Integer id, String question, List<String> possibleAns, String ans) {
		super();
		this.id =id;
		this.question = question;
		this.possibleAns = possibleAns;
		this.ans = ans;
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<String> getPossibleAns() {
		return possibleAns;
	}
	public void setPossibleAns(List<String> possibleAns) {
		this.possibleAns = possibleAns;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	
	

}
