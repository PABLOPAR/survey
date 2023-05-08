package com.pablop.survey.web.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pablop.survey.web.app.models.entity.OptionQuestionCategory;

@Service
@Primary
public class QuestionOptionServiceImp implements IQuestionOptionService{
	
	@Autowired
	private ICategoryOptionCrud ICategoryOptionCrud;

	@Override
	@Transactional(readOnly = true)
	public List<OptionQuestionCategory> getOptionQuestionList() {

		return (List<OptionQuestionCategory>) ICategoryOptionCrud.findAll();
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public int findRankingById(Long id) {

		int rankingSearched = 0;
		int index = 0;

		List<OptionQuestionCategory> allOptionsAvailable = getOptionQuestionList();

		while (index < allOptionsAvailable.size() && rankingSearched == 0) {
			if (allOptionsAvailable.get(index).getId().equals(id)) {
				rankingSearched = allOptionsAvailable.get(index).getRankingOption();

			} else {
				index++;
			}
		}

		return rankingSearched;

	}
	
	
}
