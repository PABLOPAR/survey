package com.pablop.survey.web.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.RequestScope;
import com.pablop.survey.web.app.models.entity.PeopleAnalyzed;
import com.pablop.survey.web.app.models.entity.Survey;

@Service("peopleImplementationLocale")
@RequestScope
@Primary
public class PeopleServiceImpl implements IPeopleService {

	
	@Autowired
	private IPeopleServiceCrud 	iPeopleServiceCrud;
	
		
	List<PeopleAnalyzed> peopleAnalyzedList;

	
	@Autowired
	CountryListService countryListObject;

	List<Survey> surveyList;

	
	
	
	public PeopleServiceImpl() {


	}
	
	
	@Override
	@Transactional(readOnly = true)
	public List<PeopleAnalyzed> peopleListAnalized() {
		return (List<PeopleAnalyzed>) iPeopleServiceCrud.findAll();
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public PeopleAnalyzed analyzedByEmail(String email) {

		PeopleAnalyzed peopleSearched = null;
		int index = 0;

		peopleAnalyzedList = peopleListAnalized();

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
	
	@Override
	@Transactional
	public void addPeopleAnalyzed(PeopleAnalyzed newPeople) {
		if (newPeople != null) {
			iPeopleServiceCrud.save(newPeople);

		}

	}

	@Override
	@Transactional(readOnly = true)
	public List<PeopleAnalyzed> getPeopleAnalyzedList() {
		return (List<PeopleAnalyzed>) iPeopleServiceCrud.findAll();
	}
	
	
	
	
//	@Transactional(readOnly = true)
//	public void setPeopleAnalyzedList(List<PeopleAnalyzed> peopleAnalyzedList) {
//		this.peopleAnalyzedList = peopleAnalyzedList;
//	}

	
	
	@Override
	public String toString() {
		return "PeopleServiceImpl [peopleAnalyzedList=" + peopleAnalyzedList + "]";
	}

	
	
	@Override
	public PeopleAnalyzed findPeopleById(Long id) {
		// Not Implemented yet
		return iPeopleServiceCrud.findById(id).orElse(null);
	}

	
	@Override
	public void deletePeopleAnalyzedById(Long id) {
		
		PeopleAnalyzed peopleToDelete= iPeopleServiceCrud.findById(id).orElse(null);
		iPeopleServiceCrud.delete(peopleToDelete);
		
	}


	

}
