package com.test.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class QuestionBank {
	
	Question question[];

	public Question[] getQuestion() {
		return question;
	}

	@XmlElement
	public void setQuestion(Question[] question) {
		this.question = question;
	}
}
