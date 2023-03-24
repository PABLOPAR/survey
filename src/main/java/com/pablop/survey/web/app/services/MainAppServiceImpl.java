package com.pablop.survey.web.app.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.pablop.survey.web.app.models.entity.Survey;
import com.pablop.survey.web.app.models.entity.User;

@Component
public class MainAppServiceImpl implements MainAppService{

	private ArrayList<Survey> surveyList;
	private ArrayList<User> userList;
	
	
	public MainAppServiceImpl() {
		super();
		surveyList= new ArrayList<Survey>();
		userList= new ArrayList<User>();
		
		
		
	    String richard="20/10/1980"; 
	    Date richardBirth=null;
	    try {
			Date richardBirth2=new SimpleDateFormat("dd/MM/yyyy").parse(richard);
			richardBirth=richardBirth2;
						
		} catch (ParseException e) {
		// TODO Auto-generated catch block
			richardBirth=null;
			e.printStackTrace();
		}  
		
	    String dave="10/08/2000"; 
	    Date daveBirth=null;
	    try {
			Date daveBirth2=new SimpleDateFormat("dd/MM/yyyy").parse(dave);
			daveBirth=daveBirth2;
						
		} catch (ParseException e) {
		// TODO Auto-generated catch block
			daveBirth=null;
			e.printStackTrace();
		}  	
	    
	    String gilbert="05/11/2005"; 
	    Date gilbertBirth=null;
	    try {
			Date gilbertBirth2=new SimpleDateFormat("dd/MM/yyyy").parse(gilbert);
			gilbertBirth=gilbertBirth2;
						
		} catch (ParseException e) {
		// TODO Auto-generated catch block
			gilbertBirth=null;
			e.printStackTrace();
		}  		    
	    
	    addUser(new User(richardBirth, "Richard", "richard@gmail.com"));
	    addUser(new User(daveBirth, "Dave", "dave@gmail.com"));
	    addUser(new User(gilbertBirth, "Gilbert", "gilbert@gmail.com"));
		
	}
	
	
	public User addUser(User user) {

		if (user != null) {

			if (searchUserByEmail(user.getEmail()) == null) {

				userList.add(user);
			}
		}
		return user;
	}
	
	
	public User searchUserByEmail(String email) {
		User userSearched = null;
		int index = 0;

		if (!email.isEmpty()) {

			while (index < userList.size() && userSearched == null) {
				if (userList.get(index).getEmail().equalsIgnoreCase(email)) {
					userSearched = userList.get(index);

				} else {
					index++;
				}
			}
		}
		return userSearched;
	}
	
	


	public ArrayList<Survey> getSurveyList() {
		return surveyList;
	}


	public void setSurveyList(ArrayList<Survey> surveyList) {
		this.surveyList = surveyList;
	}


	public ArrayList<User> getUserList() {
		return userList;
	}


	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}
	
	
	
	
	
}
