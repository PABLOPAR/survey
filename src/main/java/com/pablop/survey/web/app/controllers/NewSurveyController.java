package com.pablop.survey.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.pablop.survey.web.app.models.entity.Category;
import com.pablop.survey.web.app.models.entity.Question;
import com.pablop.survey.web.app.models.entity.Survey;
import com.pablop.survey.web.app.services.ICategoryService;
import com.pablop.survey.web.app.services.IOptionQuestionCategoryCrud;
import com.pablop.survey.web.app.services.IServiceSurvey;

@Controller
@RequestMapping("/app/survey")
@SessionAttributes("survey")
public class NewSurveyController {

	@Value("${text.SurveySetUpController.titleSetUpIndex}")
	private String titleSetUpIndex;

	@Value("${text.SurveySetUpController.addSurveyNameTitle}")
	private String addSurveyNameTitle;

	@Value("${text.AppAdminController.selectCategory}")
	private String selectCategory;

	@Value("${text.SurveyListController.NameNotRepeated}")
	private String NameNotRepeated;

	@Value("${text.NewSurveyController.AddNewCategory}")
	private String AddNewCategory;

	@Value("${text.NewSurveyController.ViewCatDetail}")
	private String ViewCatDetail;

	@Value("${text.questionSetUpController.categoryAlreadySelected}")
	private String categoryAlreadySelected;

	@Autowired
	private IOptionQuestionCategoryCrud iOptionQuestionCategoryCrud;

	@Autowired
	private ICategoryService iCategoryService;

	@Autowired
	private IServiceSurvey iServiceSurvey;

	@GetMapping("/surveysetup")
	public String surveyIndexSetUp(Model model) {

		Survey survey = new Survey();
		ArrayList<Category> categoryOptionList = (ArrayList<Category>) iCategoryService.getListCategory();
		model.addAttribute("titleSetUpIndex", titleSetUpIndex);
		model.addAttribute("addSurveyNameTitle", addSurveyNameTitle);
		model.addAttribute("selectCategory", selectCategory);
		model.addAttribute("survey", survey);
		model.addAttribute("categoryOptionList", categoryOptionList);
		model.addAttribute("AddNewCategory", AddNewCategory);
		model.addAttribute("ViewCatDetail", ViewCatDetail);
		model.addAttribute("categoryAlreadySelected", categoryAlreadySelected);
		return "newsurvey";

	}

	@PostMapping("/surveysetup")
	public String createSurvey(@Valid Survey survey, BindingResult result, Model model) {

		if (result.hasErrors()) {
			ArrayList<Category> categoryOptionList = (ArrayList<Category>) iCategoryService.getListCategory();
			model.addAttribute("titleSetUpIndex", titleSetUpIndex);
			model.addAttribute("addSurveyNameTitle", addSurveyNameTitle);
			model.addAttribute("selectCategory", selectCategory);
			model.addAttribute("survey", survey);
			model.addAttribute("categoryOptionList", categoryOptionList);
			model.addAttribute("AddNewCategory", AddNewCategory);
			model.addAttribute("ViewCatDetail", ViewCatDetail);
			model.addAttribute("categoryAlreadySelected", categoryAlreadySelected);
			return "newsurvey";
		}

		int iniSize = iServiceSurvey.findSurveyList().size();

		iServiceSurvey.save(survey);

		int finSize = iServiceSurvey.findSurveyList().size();

		if (iServiceSurvey.surveyfindById(survey.getId()) != null) {

			finSize++;
		}

		if (iniSize - finSize == 0) {
			ArrayList<Category> categoryOptionList = (ArrayList<Category>) iCategoryService.getListCategory();
			model.addAttribute("titleSetUpIndex", titleSetUpIndex);
			model.addAttribute("addSurveyNameTitle", addSurveyNameTitle);
			model.addAttribute("selectCategory", selectCategory);
			model.addAttribute("survey", survey);
			model.addAttribute("categoryOptionList", categoryOptionList);
			model.addAttribute("NameNotRepeated", NameNotRepeated);
			model.addAttribute("AddNewCategory", AddNewCategory);
			model.addAttribute("ViewCatDetail", ViewCatDetail);
			model.addAttribute("categoryAlreadySelected", categoryAlreadySelected);
			return "newsurvey";
		} else {

			return "redirect:/app/survey/list";

		}

	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model, SessionStatus status) {

		if (id > 0) {

			Survey surveyToBeEdited = iServiceSurvey.surveyfindById(id);

			if (surveyToBeEdited != null) {

				Survey survey = surveyToBeEdited;
				ArrayList<Category> categoryOptionList = (ArrayList<Category>) iCategoryService.getListCategory();
				model.addAttribute("titleSetUpIndex", titleSetUpIndex);
				model.addAttribute("addSurveyNameTitle", addSurveyNameTitle);
				model.addAttribute("selectCategory", selectCategory);
				model.addAttribute("survey", survey);
				model.addAttribute("categoryOptionList", categoryOptionList);
				model.addAttribute("AddNewCategory", AddNewCategory);
				model.addAttribute("ViewCatDetail", ViewCatDetail);
				model.addAttribute("categoryAlreadySelected", categoryAlreadySelected);
				return "newsurvey";

			}

		}
		status.setComplete();
		return "redirect:/app/survey/list";
	}

	@GetMapping("/categorylistdetail/{id}")
	public String setOptions(@PathVariable Long id, Model model) {
		
		Survey survey=new Survey();
		survey.setCategoryOptionId(id);
		
		ArrayList<Category> categoryOptionList= (ArrayList<Category>) iCategoryService.getListCategory();
		model.addAttribute("titleSetUpIndex", titleSetUpIndex);
		model.addAttribute("addSurveyNameTitle", addSurveyNameTitle);
		model.addAttribute("selectCategory", selectCategory);
		model.addAttribute("survey",survey );
		model.addAttribute("categoryOptionList", categoryOptionList);	
		model.addAttribute("AddNewCategory", AddNewCategory);	
		model.addAttribute("ViewCatDetail", ViewCatDetail);		
		model.addAttribute("categoryAlreadySelected", categoryAlreadySelected);
		
//		
//		model.addAttribute("", );			
//		model.addAttribute("", );		
		
		
		return "newsurvey";
	}

}
