package com.pablop.survey.web.app.controllers;

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
	
	@Value ("${text.AppAdminController.addOption}")
	private String addOption;
	
	@Value("${text.questionSetUpController.textAddNewCategory}")
	private String textAddNewCategory;
	
	
	@Value("${text.questionSetUpController.selectThisOption}")
	private String selectThisOption;
	
	@Value("${text.questionSetUpController.categoryNumber}")
	private String categoryNumber;	
	
	
	
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

		
		iCategoryService.saveCategory(category);
		status.setComplete();
		return "redirect:/app/admin/questionsetup/categorylistdetail";
	}
	
	
	
	
	
	@GetMapping ("/questionsetup")
	public String questionsetup(Model model) {
		model.addAttribute("titleNewCategory", titleNewCategory);
		
		
		return "questionsetup";
	}
	

	@GetMapping("/categorylistdetail")
	public String categoryListDetail(Model model) {
		
		List<Category> categoryList= iCategoryService.getListCategory();
		
		model.addAttribute("iCategoryService", iCategoryService);
		
		
		model.addAttribute("titleCategoryDetail", titleCategoryDetail);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("textAddNewCategory", textAddNewCategory);
		model.addAttribute("addOption", addOption);
		model.addAttribute("selectThisOption", selectThisOption);
		
		model.addAttribute("categoryNumber",categoryNumber );	
//		model.addAttribute("", );	
		

		
		
		
		
		
		return "categorylistdetail";
	}
	
	


	
	
}
