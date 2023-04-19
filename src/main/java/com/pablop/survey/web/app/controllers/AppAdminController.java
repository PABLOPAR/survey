package com.pablop.survey.web.app.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.pablop.survey.web.app.editors.CategoryOptionEditor;
import com.pablop.survey.web.app.models.entity.Category;
import com.pablop.survey.web.app.models.entity.OptionQuestionCategory;
import com.pablop.survey.web.app.services.ICategoryService;
import com.pablop.survey.web.app.services.IOptionQuestionCategoryCrud;
import com.pablop.survey.web.app.services.IQuestionCrud;

@Controller
@RequestMapping("/app/admin")
@SessionAttributes("optionQuestionCategory")
public class AppAdminController {
	
	@Value ("${text.addNewQuestionOptionTitle}")
	private String title;
	
	@Value ("${text.AppAdminController.addOption}")
	private String addOption;
	
	@Value ("${text.AppAdminController.selectCategory}")
	private String selectCategory;
	
	
	@Value ("${text.questionSetUpController.addRanking}")
	private String addRanking;
	
	@Value ("${text.questionSetUpController.addRankingExplanation}")
	private String addRankingExplanation;

	@Value("${text.questionSetUpController.categoryAlreadySelected}")
	private String categoryAlreadySelected;
	
	
	
	
	
	@Autowired
	private IQuestionCrud iquestiocrud;
	
	@Autowired
	private IOptionQuestionCategoryCrud iOptionQuestionCategoryCrud;
	
	
	@Autowired
	private ICategoryService iCategoryService;
	
	@Autowired
	private CategoryOptionEditor categoryOptionEditor;
	
	
	
	

	
	

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
//		binder.registerCustomEditor(CategoryOption.class, "categoryOption", (PropertyEditor) categoryOptionEditor);
		
	}
	

	
	
	
	@GetMapping("/setup/addnewquestionoption/{id}")
	public String getNewQuestionOptionForm(@PathVariable Long id, Model model) {
		
		ArrayList<Category> categoryOptionList= (ArrayList<Category>) iCategoryService.getListCategory();
		OptionQuestionCategory optionQuestionCategory=new OptionQuestionCategory();
		optionQuestionCategory.setCategoryOptionId(id);

		
		model.addAttribute("optionQuestionCategory", optionQuestionCategory);
		model.addAttribute("addOption", addOption);
		model.addAttribute("categoryAlreadySelected", categoryAlreadySelected);
		model.addAttribute("categoryOptionList", categoryOptionList);
		model.addAttribute("title", title);
		model.addAttribute("addRanking", addRanking);
		model.addAttribute("addRankingExplanation", addRankingExplanation);
		
		
		return "addnewquestionoption";
	}
	
	
	@PostMapping("/setup/addnewquestionoption")
	public String addNewQuestionOption(@Valid OptionQuestionCategory optionQuestionCategory, BindingResult result,Model model, SessionStatus status) {
		
		ArrayList<Category> categoryOptionList= (ArrayList<Category>) iCategoryService.getListCategory();
		
		
		
		if (result.hasErrors()) {
			model.addAttribute("title", title);
			model.addAttribute("optionQuestionCategory", optionQuestionCategory);
			model.addAttribute("addOption", addOption);
			model.addAttribute("categoryAlreadySelected", categoryAlreadySelected);
			model.addAttribute("categoryOptionList", categoryOptionList);
			model.addAttribute("addRanking", addRanking);
			model.addAttribute("addRankingExplanation", addRankingExplanation);
			return "addnewquestionoption";
		}
		
		iOptionQuestionCategoryCrud.save(optionQuestionCategory);
		status.setComplete();
	
		return "redirect:/app/admin/questionsetup/categorylistdetail";
	}

}
