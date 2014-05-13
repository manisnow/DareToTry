package com.test.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.test.domain.Question;
import com.test.domain.QuestionBank;

@Service
public class QuestionBankServiceImpl implements QuestionBankService{

	@Override
	public QuestionBank getQuestions(String path) {
	// TODO Auto-generated method stub
		QuestionBank questionBank=com.test.util.UTIL.getQusetions(path);
	List<List<Integer>> list=	com.test.util.UTIL.getRandomNumbersArray(questionBank.getQuestion().length);
    List<Question> questionList=Arrays.asList(questionBank.getQuestion());
    int randomInt=com.test.util.UTIL.getRandomInteger(0, questionBank.getQuestion().length-1);
    System.out.println(randomInt);
    
    
     com.test.util.UTIL.swapArray(questionList,list.get(randomInt)) ;
	  questionBank.setQuestion(questionList.toArray(new Question[0]));
		return questionBank;
		
	}
}
