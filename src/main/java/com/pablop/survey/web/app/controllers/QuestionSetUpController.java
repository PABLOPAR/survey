package com.pablop.survey.web.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.pablop.survey.web.app.models.entity.Category;
import com.pablop.survey.web.app.services.ICategoryService;

@Controller 
@RequestMapping("/app/admin/questionsetup")
@SessionAttributes("category")
public class QuestionSetUpController {

	
	@Value("${text.questionSetUpController.titleNewCategory}")
	private String titleNewCategory;
	
	@Value("${text.questionSetUpController.titleSetQuestion}")
	private String titleSetQuestion;
	
	@Value("${text.questionSetUpController.titleCategoryDetail}")
	private String titleCategoryDetail;
	
	
	
	@Value("${text.questionSetUpController.textAddNewCategory}")
	private String textAddNewCategory;
	
	@Autowired
	private ICategoryService iCategoryService;

	
	@GetMapping("/addnewcategory")
	private String getFormNewCategoryOption(Model model) {
		
		Category category= new Category();
		
		
		
		model.addAttribute("titleNewCategory", titleNewCategory);
		model.addAttribute("textAddNewCategory", textAddNewCategory);
		model.addAttribute("categoryOption", category);	
		
		
		return "addcategoryoption";
	}
	
	
	
	@PostMapping("addnewcategory")
	private String addNewCategoryOption(@Valid Category category, BindingResult result,  Model model, SessionStatus status) {
		
		if (result.hasErrors()) {
			model.addAttribute("titleNewCategory", titleNewCategory);
			model.addAttribute("textAddNewCategory", textAddNewCategory);
			model.addAttribute("categoryOption", category);	
			return "addcategoryoption";
		}
		
System.out.println("llego hasta aca" + category.toString());
		
		iCategoryService.saveCategory(category);
		status.setComplete();
		return "redirect:/app/survey/list";
	}
	
	
	
	
	
	@GetMapping ("/questionsetup")
	public String questionsetup(Model model) {
		model.addAttribute("titleNewCategory", titleNewCategory);
		
		
		return "questionsetup";
	}
	

	@GetMapping("/categorylistdetail")
	public String categoryListDetail(Model model) {
		
		List<Category> categoryList= iCategoryService.getListCategory();
		
		model.addAttribute("titleCategoryDetail", titleCategoryDetail);
		model.addAttribute("categoryList", categoryList);
		
		
		
		
		return "categorylistdetail";
	}
	
	
	
	
}
