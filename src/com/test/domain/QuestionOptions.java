package com.test.domain;

public class QuestionOptions {

	String option;
	int id;
	boolean isAnswer;

	 public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean getAnswer() {
		return isAnswer;
	}
	
	public void setAnswer(boolean isAnswer) {
		this.isAnswer = isAnswer;
	}
	public QuestionOptions(){
		 
	 }
	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}
   
}
