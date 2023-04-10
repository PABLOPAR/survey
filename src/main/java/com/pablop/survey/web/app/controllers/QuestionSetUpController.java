package com.pablop.survey.web.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pablop.survey.web.app.models.entity.CategoryOption;
import com.pablop.survey.web.app.services.ICategoryOptionCrud;

@Controller 
@RequestMapping("/app/admin/questionsetup")
public class QuestionSetUpController {

	
	@Value("${text.questionSetUpController.titleNewCategory}")
	private String titleNewCategory;
	
	@Value("${text.questionSetUpController.titleSetQuestion}")
	private String titleSetQuestion;
	
	
	
	@Value("${text.questionSetUpController.textAddNewCategory}")
	private String textAddNewCategory;
	
	@Autowired
	private ICategoryOptionCrud iCategoryOptionCrud;
	
	
	
	@GetMapping("/addnewcategory")
	private String getFormNewCategoryOption(Model model) {
		
		CategoryOption categoryOption= new CategoryOption();
		
		
		
		model.addAttribute("titleNewCategory", titleNewCategory);
		model.addAttribute("textAddNewCategory", textAddNewCategory);
		model.addAttribute("categoryOption", categoryOption);	
		
		
		return "addcategoryoption";
	}
	
	
	
	@PostMapping("addnewcategory")
	private String addNewCategoryOption(@Valid CategoryOption categoryOption, BindingResult result,  Model model) {
		
		if (result.hasErrors()) {
			model.addAttribute("titleNewCategory", titleNewCategory);
			model.addAttribute("textAddNewCategory", textAddNewCategory);
			model.addAttribute("categoryOption", categoryOption);	
			return "addcategoryoption";
		}
		
		iCategoryOptionCrud.save(categoryOption);
		
		return "redirect:/app/index";
	}
	
	
	
	
	
	@GetMapping ("/questionsetup")
	public String questionsetup(Model model) {
		model.addAttribute("titleNewCategory", titleNewCategory);
		
		
		return "questionsetup";
	}
	

	
	
	
	
	
}
