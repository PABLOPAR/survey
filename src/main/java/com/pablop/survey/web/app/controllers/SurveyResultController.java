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
	
//	@Value("${}")
//	private String replace;
//	
//	@Value("${}")
//	private String replace;
//		
//	@Value("${}")
//	private String replace;
//	
//	@Value("${}")
//	private String replace;
	
	
	
	
	
	
	
	
	
	
	@GetMapping("{id}")
	public String loadResults(@PathVariable Long id, Model model) {

		Survey surveyAnalyzed = iServiceSurvey.surveyfindById(id);
		
System.out.println("surveyAnalyzed SURVRESULTCONTR "+surveyAnalyzed);		

		List<Question> questionsAnalyzed = surveyAnalyzed.getSurveyQuestions();

//System.out.println("questionsAnalyzed SURVRESULTCONTR "	+questionsAnalyzed);	
		
		
		Long categoryOptionId = surveyAnalyzed.getCategoryOptionId();
		
//System.out.println("categoryOptionId SURVRESULTCONTR "+	categoryOptionId);	

		List<OptionQuestionCategory> optionQuestionCategory = iQuestionOptionService.getOptionQuestionList();

//System.out.println("optionQuestionCategory SURVRESULTCONTR "+optionQuestionCategory	);			
		
		ArrayList<OptionQuestionCategory> optionInclInCatSelect = new ArrayList<OptionQuestionCategory>();

Long idSurveyPersonAnalyz = surveyAnalyzed.getIdPeopleAnalized();

//System.out.println("idSurveyPersonAnalyz SURVRESULTCONTR "+	idSurveyPersonAnalyz);
		
		PeopleAnalyzed personAnalyzed = iPeopleService.findPeopleById(idSurveyPersonAnalyz);

//System.out.println("personAnalyzed SURVRESULTCONTR "+personAnalyzed	);
		
		for (OptionQuestionCategory option : optionQuestionCategory) {
			if (option.getCategoryOptionId().equals(categoryOptionId)) {
				optionInclInCatSelect.add(option);
			}
		}

		int maxRankingValue = 0;

		for (OptionQuestionCategory option : optionInclInCatSelect) {

			if (option.getRankingOption() > maxRankingValue) {
				maxRankingValue = option.getRankingOption();
//System.out.println("maxRankingValue SURVRESULTCONTR "+maxRankingValue);				
				
			}
		}

		double maxScoreforTest = 0;
		double surveyScore = 0;
		double questionResult = 0;
		for (Question question : questionsAnalyzed) {

			if (question.getIdValChos() != null) {
System.out.println("QuestionImportance SURVRESULTCONTR "+(question.getQuestionImportance() / 10));				
System.out.println("IdValChos SURVRESULTCONTR "+(question.getIdValChos()));		
System.out.println("findRankingById SURVRESULTCONTR "+iQuestionOptionService.findRankingById(question.getIdValChos()));	

				
				questionResult = ((double)question.getQuestionImportance() / 10)
						* iQuestionOptionService.findRankingById(question.getIdValChos());
				
				
				
				System.out.println("questionResul SURVRESULTCONTR "+questionResult);
				surveyScore = surveyScore + questionResult;
				System.out.println("surveyScore SURVRESULTCONTR "+surveyScore);
				maxScoreforTest = maxScoreforTest * ((double)question.getQuestionImportance() / 10) + maxScoreforTest;
				System.out.println("maxScoreforTest SURVRESULTCONTR "+maxScoreforTest);
			}
		}
System.out.println("optionInclInCatSelect SURVRESULTCONTR "+optionInclInCatSelect);

		surveyAnalyzed.setSurveyScore(surveyScore);
System.out.println("maxScoreforTest SURVRESULTCONTR "+maxScoreforTest	);
System.out.println("surveyScore SURVRESULTCONTR "+surveyScore	);
System.out.println("questionResult SURVRESULTCONTR "+questionResult	);

		model.addAttribute("title", title);
		model.addAttribute("maxScoreSurveyText", maxScoreSurveyText);
		model.addAttribute("ScoreResult", ScoreResult);
		model.addAttribute("surveyScore", surveyScore);
		model.addAttribute("maxScoreforTest", maxScoreforTest);
		model.addAttribute("personAnalyzed", personAnalyzed);
//		model.addAttribute("", );
//		model.addAttribute("", );
//		model.addAttribute("", );

		return "surveyresult";
	}
}
