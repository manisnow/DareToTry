package com.test.controller;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.domain.AnswerType;
import com.test.domain.Question;
import com.test.domain.QuestionBank;
import com.test.domain.QuestionOptions;
import com.test.service.QuestionBankService;

@Controller
public class DareToTryController {
	
	private static final Log logger = LogFactory.getLog(DareToTryController.class);
	
	@Autowired
	ServletContext servletContext;
	@Autowired
	QuestionBankService questionBankService;
	
	
     
    @RequestMapping(value = DareToTryConstants.GET_QUESTIONS, method = RequestMethod.GET)
    public @ResponseBody QuestionBank etDummyEmployee() {
    	Question question[]=new Question[2];
    	QuestionOptions questionOptions[]=new QuestionOptions[2];
    	questionOptions[0]=new QuestionOptions();
    	questionOptions[1]=new QuestionOptions();
    	questionOptions[0].setOption("hello3");
    	questionOptions[1].setOption("hello2");    	
    	question[0]=new Question();
    	question[0].setAnswerType(AnswerType.SINGLEANSWER);
    	//question[0].setQuestion("helllo ?");
         
    	question[0].setQuestionOptions(questionOptions);
    	//System.out.println(servletContext.getRealPath("/WEB-INF/file/"));
        return questionBankService.getQuestions(servletContext.getRealPath("/WEB-INF/file/"));
    }
     
   
}
	
	

