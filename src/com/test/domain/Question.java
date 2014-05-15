package com.test.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class Question {
	
	 QuestionTag questionTag;
	QuestionOptions questionOptions[];
	AnswerType answerType;
	
	public Question(){
		
	}
	public QuestionTag getQuestionTag() {
		return questionTag;
	}
	
	@XmlElement
	public void setQuestionTag(QuestionTag  questionTag) {
		this.questionTag = questionTag;
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
