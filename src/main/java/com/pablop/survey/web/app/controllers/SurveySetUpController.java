package com.pablop.survey.web.app.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pablop.survey.web.app.editors.CategoryOptionEditor;
import com.pablop.survey.web.app.models.entity.CategoryOption;
import com.pablop.survey.web.app.models.entity.Survey;
import com.pablop.survey.web.app.services.ICategoryOptionCrud;
import com.pablop.survey.web.app.services.IOptionQuestionCategoryCrud;

@Controller 
@RequestMapping("/app/admin")
public class SurveySetUpController {
	
	
	@Value("${text.SurveySetUpController.titleSetUpIndex}")
	private String titleSetUpIndex;
	

	@Value("${text.SurveySetUpController.addSurveyNameTitle}")
	private String addSurveyNameTitle;
	
	@Value ("${text.AppAdminController.selectCategory}")
	private String selectCategory;
//	
//	@Value("${}")
//	private String ;
//	
//	@Value("${}")
//	private String ;
//	
//	@Value("${}")
//	private String ;
	
	
	@Autowired
	private IOptionQuestionCategoryCrud iOptionQuestionCategoryCrud;
	
	
	@Autowired
	private ICategoryOptionCrud iCategoryOptionCrud;
	

	
	
	
	@GetMapping ("/surveysetup")
	public String surveyIndexSetUp(Model model) {
		
		Survey survey=new Survey();
		ArrayList<CategoryOption> categoryOptionList= (ArrayList<CategoryOption>) iCategoryOptionCrud.findAll();
		
		
		model.addAttribute("titleSetUpIndex", titleSetUpIndex);
		model.addAttribute("addSurveyNameTitle", addSurveyNameTitle);
		model.addAttribute("selectCategory", selectCategory);
		model.addAttribute("survey",survey );
		model.addAttribute("categoryOptionList", categoryOptionList);		
//		model.addAttribute("", );	
//		model.addAttribute("", );	
//		model.addAttribute("", );	
//		model.addAttribute("", );	
//		model.addAttribute("", );	
		return "surveyindexsetup";
	}
	
	
	
	
	@PostMapping ("/surveysetup")
	public String createSurvey(@Valid Survey survey, BindingResult result, Model model) {
		
		if (result.hasErrors()) {

			return "surveysetup";
		}


		
		model.addAttribute("titleSetUpIndex", titleSetUpIndex);
//		model.addAttribute("addSurveyNameTitle",addSurveyNameTitle );
		model.addAttribute("survey",survey );
//		model.addAttribute("", );		
//		model.addAttribute("", );	
//		model.addAttribute("", );	
//		model.addAttribute("", );	
//		model.addAttribute("", );	
//		model.addAttribute("", );	
		return "redirect:";
	}
	
	
	
	
	

}
