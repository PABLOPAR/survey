package com.pablop.survey.web.app.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import com.pablop.survey.web.app.models.entity.Country;
import com.pablop.survey.web.app.models.entity.PeopleAnalyzed;
import com.pablop.survey.web.app.models.entity.Survey;

@Service("peopleImplementationLocale")
@RequestScope
public class PeopleServiceImpl implements IPeopleService{
	
	List<PeopleAnalyzed> peopleAnalyzedList;
	
	@Autowired
	CountryListServiceImpl countryListObject;
	
	List<Survey> surveyList;
	
	
	public PeopleServiceImpl() {
		
	    String mikeBirthS="25/01/1980"; 
	    Date mikeBirth=null;
	    
	    
	    try {
			Date mikeBirth2=new SimpleDateFormat("dd/MM/yyyy").parse(mikeBirthS);
			mikeBirth=mikeBirth2;
						
		} catch (ParseException e) {
		// TODO Auto-generated catch block
			mikeBirth=null;
			e.printStackTrace();
		}  

	    Country countryMike= new Country ("Antarctica");
	    Country countryJhon= new Country ("Austria");
	    Country countryClaude= new Country ("Spain");
	    Country countrySmith= new Country ("Austria");	    
	    
		this.peopleAnalyzedList = new ArrayList<PeopleAnalyzed>();
		
		
		PeopleAnalyzed mike=new PeopleAnalyzed("Mike", "mike@gmail.com");
		PeopleAnalyzed smith=new PeopleAnalyzed("Jeff", "Jeff@gmail.com");
		PeopleAnalyzed jhon=new PeopleAnalyzed("Jhon", "Jhon@gmail.com");
		PeopleAnalyzed claude=new PeopleAnalyzed( "Claude", "Claude@gmail.com");
		
				


		
		mike.setBirthday(mikeBirth);
		mike.setLastName("Dior");
		mike.setCountry(countryMike);
	
		
		smith.setLastName("Smith");
		smith.setCountry(countrySmith);
		

		claude.setCountry(countryClaude);

		
		jhon.setCountry(countryJhon);
	

		peopleAnalyzedList.add(mike);
		peopleAnalyzedList.add(jhon);
		peopleAnalyzedList.add(claude);
		peopleAnalyzedList.add(smith);		
		
		

		
	}

	@Override
	public List<PeopleAnalyzed> peopleListAnalized() {
		return peopleAnalyzedList;
	}

	@Override
	public PeopleAnalyzed analyzedByEmail(String email) {

		PeopleAnalyzed peopleSearched = null;
		int index = 0;

		if (!email.isEmpty()) {


			while (peopleSearched == null && peopleAnalyzedList.size() > index) {
				if (peopleAnalyzedList.get(index).getEmail().equalsIgnoreCase(email)) {
					peopleSearched = peopleAnalyzedList.get(index);
					
				} else {
					index++;
				}
			}
		}

		return peopleSearched;
	}

	public void addPeopleAnalyzed(PeopleAnalyzed newPeople) {

		if (newPeople != null) {

			peopleAnalyzedList.add(newPeople);

		}

	}

	public List<PeopleAnalyzed> getPeopleAnalyzedList() {
		return peopleAnalyzedList;
	}

	public void setPeopleAnalyzedList(List<PeopleAnalyzed> peopleAnalyzedList) {
		this.peopleAnalyzedList = peopleAnalyzedList;
	}

	@Override
	public String toString() {
		return "PeopleServiceImpl [peopleAnalyzedList=" + peopleAnalyzedList + "]";
	}

	
	@Autowired
	private CountryListServiceImpl countryListServiceImpl;
	
	

}
