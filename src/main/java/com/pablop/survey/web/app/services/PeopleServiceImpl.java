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
		Date mikeBirthay = new Date(07 / 02 / 1990);
		Date jhonBirthay = new Date(10 / 05 / 2000);
		Date claudeBirthay = new Date(20 / 12 / 2010);

		this.peopleAnalyzedList = new ArrayList<PeopleAnalyzed>();
		peopleAnalyzedList.add(new PeopleAnalyzed("England", mikeBirthay, "Mike", "mike@gmail.com"));
		peopleAnalyzedList.add(new PeopleAnalyzed("United State", jhonBirthay, "Jhon", "Jhon@gmail.com"));
		peopleAnalyzedList.add(new PeopleAnalyzed("France", claudeBirthay, "Claude", "Claude@gmail.com"));
		PeopleAnalyzed Smith=	new PeopleAnalyzed("Irland", jhonBirthay, "Jeff", "Jeff@gmail.com");
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




	
	
	
	

}
