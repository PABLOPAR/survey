package com.pablop.survey.web.app.controllers;

import java.beans.PropertyEditor;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pablop.survey.web.app.editors.CategoryOptionEditor;
import com.pablop.survey.web.app.models.entity.CategoryOption;
import com.pablop.survey.web.app.models.entity.OptionQuestionCategory;
import com.pablop.survey.web.app.services.ICategoryOptionCrud;
import com.pablop.survey.web.app.services.IOptionQuestionCategoryCrud;
import com.pablop.survey.web.app.services.IQuestionCrud;

@Controller
@RequestMapping("/app/admin")
public class AppAdminController {
	
	@Value ("${text.addNewQuestionOptionTitle}")
	private String title;
	
	@Value ("${text.AppAdminController.addOption}")
	private String addOption;
	
	@Value ("${text.AppAdminController.selectCategory}")
	private String selectCategory;
	
	
	@Autowired
	private IQuestionCrud iquestiocrud;
	
	@Autowired
	private IOptionQuestionCategoryCrud iOptionQuestionCategoryCrud;
	
	
	@Autowired
	private ICategoryOptionCrud iCategoryOptionCrud;
	
	@Autowired
	private CategoryOptionEditor categoryOptionEditor;
	
	

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		binder.registerCustomEditor(CategoryOption.class, "categoryOption", (PropertyEditor) categoryOptionEditor);
		
	}
	
	
	
	
	
	@GetMapping("/setup/addnewquestionoption")
	public String getNewQuestionOptionForm(Model model) {
		
		ArrayList<CategoryOption> categoryOptionList= (ArrayList<CategoryOption>) iCategoryOptionCrud.findAll();
		OptionQuestionCategory optionQuestionCategory=new OptionQuestionCategory();
		
		
		model.addAttribute("optionQuestionCategory", optionQuestionCategory);
		model.addAttribute("addOption", addOption);
		model.addAttribute("selectCategory", selectCategory);
		model.addAttribute("categoryOptionList", categoryOptionList);
		model.addAttribute("title", title);

	
		return "addnewquestionoption";
	}
	
	
	@PostMapping("/setup/addnewquestionoption")
	public String addNewQuestionOption(@Valid OptionQuestionCategory optionQuestionCategory, BindingResult result,Model model) {
		
		ArrayList<CategoryOption> categoryOptionList= (ArrayList<CategoryOption>) iCategoryOptionCrud.findAll();
		
		if (result.hasErrors()) {
			model.addAttribute("title", title);
			model.addAttribute("optionQuestionCategory", optionQuestionCategory);
			model.addAttribute("addOption", addOption);
			model.addAttribute("selectCategory", selectCategory);
			model.addAttribute("categoryOptionList", categoryOptionList);
						
			return "addnewquestionoption";
		}
		System.out.println("Cumple" + optionQuestionCategory);
		
		iOptionQuestionCategoryCrud.save(optionQuestionCategory);
		
	
		return "redirect:/app/index";
	}

}
