package com.pablop.survey.web.app.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import com.pablop.survey.web.app.models.entity.PeopleAnalyzed;

@Service("peopleImplementationLocale")
@RequestScope
@Primary
public class PeopleServiceImpl implements PeopleService{
	
	List<PeopleAnalyzed> peopleAnalyzedList;
	
	public PeopleServiceImpl() {
//		Date mikeBirthay = new Date(07 / 02 / 1990);
//		Date jhonBirthay = new Date(10 / 05 / 2000);
//		Date claudeBirthay = new Date(20 / 12 / 2010);

		this.peopleAnalyzedList = new ArrayList<PeopleAnalyzed>();
		peopleAnalyzedList.add(new PeopleAnalyzed("England",  "Mike", "mike@gmail.com"));
		peopleAnalyzedList.add(new PeopleAnalyzed("United State",  "Jhon", "Jhon@gmail.com"));
		peopleAnalyzedList.add(new PeopleAnalyzed("France", "Claude", "Claude@gmail.com"));
		PeopleAnalyzed Smith=	new PeopleAnalyzed("Irland", "Jeff", "Jeff@gmail.com");
		Smith.setLastName("Smith");
		peopleAnalyzedList.add(Smith);
		
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

	public List<PeopleAnalyzed> addPeopleAnalyzed(PeopleAnalyzed newPeople) {

		List<PeopleAnalyzed> updatedList=peopleAnalyzedList;
		
		updatedList.add(newPeople);
		
		System.out.println("MIRAR ACA2= "+ updatedList.toString());
		
		peopleAnalyzedList=updatedList;
		
		setPeopleAnalyzedList(updatedList);
		

		return updatedList;
		
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
	};


	
	
	
	

}
