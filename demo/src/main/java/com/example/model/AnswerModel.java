package com.example.model;

public class AnswerModel {
	
	private Integer qsnId;
	private String answer;
	public AnswerModel(Integer qsnId, String answer) {
		super();
		this.qsnId = qsnId;
		this.answer = answer;
	}
	public Integer getQsnId() {
		return qsnId;
	}
	public void setQsnId(Integer qsnId) {
		this.qsnId = qsnId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public AnswerModel() {

		// TODO Auto-generated constructor stub
	}
	
	

}
