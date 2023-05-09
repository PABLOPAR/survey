package com.pablop.survey.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pablop.survey.web.app.models.entity.OptionQuestionCategory;
import com.pablop.survey.web.app.models.entity.PeopleAnalyzed;
import com.pablop.survey.web.app.models.entity.Question;
import com.pablop.survey.web.app.models.entity.Survey;
import com.pablop.survey.web.app.services.ICategoryService;
import com.pablop.survey.web.app.services.IPeopleService;
import com.pablop.survey.web.app.services.IQuestionOptionService;
import com.pablop.survey.web.app.services.IServiceSurvey;

@Controller
@RequestMapping(value="app/survey/results/")
public class SurveyResultController {

	@Autowired
	private IServiceSurvey iServiceSurvey;
	
	@Autowired
	ICategoryService iCategoryService;
	
	@Autowired
	IQuestionOptionService iQuestionOptionService;
	
	@Autowired	
	IPeopleService iPeopleService;
	
	@Value("${text.SurveyResult.title}")
	private String title;
	
	@Value("${text.SurveyResult.maxScoreSurveyText}")
	private String maxScoreSurveyText;
	
	@Value("${text.SurveyResult.ScoreResult}")
	private String ScoreResult;
	
	@Value("${text.back}")
	private String back;
	
	@Value("${text.SurveyResultController.trust}")
	private String trust;
		
	@Value("${text.SurveyResultController.beAware}")
	private String beAware;
	
	@Value("${text.SurveyResultController.analyze}")
	private String analyze;
	

	
	
	
	
	
	
	
	
	@GetMapping("{id}")
	public String loadResults(@PathVariable Long id, Model model) {

		Survey surveyAnalyzed = iServiceSurvey.surveyfindById(id);
		
		List<Question> questionsAnalyzed = surveyAnalyzed.getSurveyQuestions();
		
		Long categoryOptionId = surveyAnalyzed.getCategoryOptionId();
		
		List<OptionQuestionCategory> optionQuestionCategory = iQuestionOptionService.getOptionQuestionList();

			
		ArrayList<OptionQuestionCategory> optionInclInCatSelect = new ArrayList<OptionQuestionCategory>();

		Long idSurveyPersonAnalyz = surveyAnalyzed.getIdPeopleAnalized();

		PeopleAnalyzed personAnalyzed = iPeopleService.findPeopleById(idSurveyPersonAnalyz);

		for (OptionQuestionCategory option : optionQuestionCategory) {
			if (option.getCategoryOptionId().equals(categoryOptionId)) {
				optionInclInCatSelect.add(option);
			}
		}

		int maxRankingValue = 0;

		for (OptionQuestionCategory option : optionInclInCatSelect) {

			if (option.getRankingOption() > maxRankingValue) {
				maxRankingValue = option.getRankingOption();

			}
		}

		double maxScoreforTest = 0;
		double surveyScore = 0;
		double questionResult = 0;
		double questionResultMaxPossib=0;
		double maxPossibleQuestResult=0;
		
		for (Question question : questionsAnalyzed) {

			if (question.getIdValChos() != null) {


				questionResult = ((double) question.getQuestionImportance() / 10)
						* iQuestionOptionService.findRankingById(question.getIdValChos());

				surveyScore = surveyScore + questionResult;
				
				
				questionResultMaxPossib=((double) question.getQuestionImportance() / 10)* maxRankingValue;

				maxPossibleQuestResult=maxPossibleQuestResult+questionResultMaxPossib;

				
				
			}
		}

		double percentageObtain= (surveyScore/maxPossibleQuestResult)*100;
		
		surveyAnalyzed.setSurveyScore(surveyScore);
		
			
		iServiceSurvey.edit(surveyAnalyzed);
		
		float score= (float) surveyScore;
		String resultScore=String.format("%.2f", score);
		
		float maxScore= (float) maxPossibleQuestResult;
		String maxPosiVal=String.format("%.2f", maxScore);	
		
		
		
		
		double possitive=(surveyScore/maxPossibleQuestResult)*10;
		double negative=10-possitive;
		
		
		model.addAttribute("possitive", possitive);
		model.addAttribute("negative", negative);
		
		
		
		
		
		
		
		model.addAttribute("title", title);
		model.addAttribute("maxPossibleQuestResult", maxPosiVal);
		model.addAttribute("ScoreResult", ScoreResult);
		model.addAttribute("surveyScore", resultScore);
		model.addAttribute("maxScoreSurveyText", maxScoreSurveyText);
		model.addAttribute("personAnalyzed", personAnalyzed);
		model.addAttribute("back",back );
		model.addAttribute("percentageObtain",percentageObtain );
		model.addAttribute("beAware",beAware );
		model.addAttribute("trust",trust );
		model.addAttribute("analyze",analyze );		
		
		
		
		
		return "surveyresult";
	}
}
