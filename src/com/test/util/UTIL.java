package com.test.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.test.controller.DareToTryController;
import com.test.domain.AnswerType;
import com.test.domain.Question;
import com.test.domain.QuestionBank;
import com.test.domain.QuestionOptions;

public class UTIL {
	
	private static final Log logger = LogFactory.getLog(UTIL.class);
	public static List<List<Integer>> getRandomNumbersArray(int num){
		List<List<Integer>> toatalArray=new ArrayList<>();	
		int count =0;
		
		for(int i=0;i<num;i++){
			count=0;
			List<Integer> set=new ArrayList<>();
			
			for(int j=0;j<num;j++){				
				count=count+i;
				
				while(true){
					
					if(set.contains(new Integer(count%(num)))){
						count++;
					}else{
						break;
					}
					
				}
				set.add(new Integer(count%(num)));
				System.out.print((count%(num))+",");
			    	
			}
			toatalArray.add(set);
			System.out.println();
		}
		
		return 			toatalArray;
		
	}
	
	public static void main(String args[]){
		
		
		System.out.println(getRandomNumbersArray(15));
		Question question[]=new Question[2];
    	QuestionOptions questionOptions[]=new QuestionOptions[2];
    	questionOptions[0]=new QuestionOptions();
    	questionOptions[1]=new QuestionOptions();
    	questionOptions[0].setOption("hello3");
    	questionOptions[1].setOption("hello2");    	
    	questionOptions[1].setAnswer(true);
    	question[0]=new Question();
    	question[0].setAnswerType(AnswerType.SINGLEANSWER);
    	question[0].setQuestion("helllo ?");
         
    	question[0].setQuestionOptions(questionOptions);
    	
    	
    	getQuestionsXML(question[0]);   	
    	//System.out.print(getQusetions().getQuestion()[1].getQuestion());
	}
	
	public static int getRandomInteger(int aStart, int aEnd){
	    if (aStart > aEnd) {
	      throw new IllegalArgumentException("Start cannot exceed End.");
	    }
        Random aRandom=new Random();
	    //get the range, casting to long to avoid overflow problems
	    long range = (long)aEnd - (long)aStart + 1;
	    // compute a fraction of the range, 0 <= frac < range
	    long fraction = (long)(range * aRandom.nextDouble());
	    int randomNumber =  (int)(fraction + aStart);    
	   return randomNumber;
	  }
	
	public static void swapArray(List<Question> list,List<Integer> set){
		
		for(int i=0;i<list.size();i++){
			//System.out.println("i- " +i +" set -" +set.get(i));
			Question a=list.get(set.get(i));
			list.set(set.get(i),list.get(i));
			list.set(i, a);
			
		}
		
	}
	
    public static QuestionBank getQusetions(String path) {
    	QuestionBank  question=null;
    	File file = new File(path+"/file.xml");
    	JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(QuestionBank.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			 question = (QuestionBank) jaxbUnmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
    	 
		
 
		return question;	
 
    }
    
    
    public static void getQuestionsXML(Question question) {
    	
    	
    	
    	JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Question.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			  jaxbMarshaller.marshal(question,System.out);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
		
 
		
 
    }

    
    public static void Main(String args[]){
    	
    }
}
