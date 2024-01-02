package com.pablop.survey.web.app.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pablop.survey.web.app.models.entity.User;
import com.pablop.survey.web.app.services.IUserService;

@Controller
@RequestMapping("app/users")
public class UsersListController {
	
	@Value("${text.indexController.analyzedPeople.birthday}")
	private String birthday;

	@Value("${text.indexController.analyzedPeople.country}")
	private String country;

	@Value("${text.indexController.analyzedPeople.email}")
	private String email;

	@Value("${text.indexController.analyzedPeople.lastName}")
	private String lastName;

	@Value("${text.indexController.analyzedPeople.name}")
	private String name;
	
	@Value("${text.indexController.creationDate}")
	private String creationDateText;
	
	@Value("${text.delete}")
	private String delete;
	
	@Value("${text.PeopleAnalyzedController.peopleTestedProfile.addNewUser}")
	private String addNewUser;
	
	
	@Autowired
	private IUserService iUserService;
	
	@GetMapping("/userlist")
	public String showUserList(Model model) {
		
		List<User> usersList=iUserService.getUserList();
		
		Collections.sort(usersList);
		
		model.addAttribute("birthday", birthday);
		model.addAttribute("country",country );	
		model.addAttribute("email",email );
		model.addAttribute("lastName", lastName);
		model.addAttribute("name",name );
		model.addAttribute("creationDateText",creationDateText );
		model.addAttribute("delete", delete);
		model.addAttribute("usersList", usersList);
		model.addAttribute("addNewUser", addNewUser);		
		
		return "userslist";
	}

}
