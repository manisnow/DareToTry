package com.test.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class Question {
	
	String Question;
	QuestionOptions questionOptions[];
	AnswerType answerType;
	
	public Question(){
		
	}
	public String getQuestion() {
		return Question;
	}
	
	@XmlElement
	public void setQuestion(String question) {
		Question = question;
	}
	public QuestionOptions[] getQuestionOptions() {
		return questionOptions;
	}
	
	@XmlElement
	public void setQuestionOptions(QuestionOptions[] questionOptions) {
		this.questionOptions = questionOptions;
	}
	
	public AnswerType getAnswerType() {
		return answerType;
	}
	
	@XmlElement
	public void setAnswerType(AnswerType answerType) {
		this.answerType = answerType;
	}

}
