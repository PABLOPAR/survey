package com.pablop.survey.web.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pablop.survey.web.app.models.entity.PeopleAnalyzed;
import com.pablop.survey.web.app.models.entity.Survey;

@Service
public class SurveyServiceImpl implements IServiceSurvey{
	
	List<Survey> surveyList;
	
	public List<Survey> exampleListSurvey(){
		
		
		PeopleAnalyzed peopleAnalyzed= new PeopleAnalyzed("Martin","martin@gmail.com");
		PeopleAnalyzed peopleAnalyzed2= new PeopleAnalyzed("German","german@gmail.com");
		
		Survey s1=new Survey("It he reliable?",peopleAnalyzed);
		Survey s2=new Survey("Is he a successful person?",peopleAnalyzed2);	
		
		ArrayList<Survey> exampleArraySurvey= new ArrayList<Survey>();
		
		exampleArraySurvey.add(s1);
		exampleArraySurvey.add(s2);
		
		return exampleArraySurvey;
	}

}
