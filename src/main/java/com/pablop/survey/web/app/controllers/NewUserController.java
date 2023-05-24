package com.pablop.survey.web.app.controllers;

import java.beans.PropertyEditor;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.pablop.survey.web.app.editors.ICountryEditor;
import com.pablop.survey.web.app.models.entity.BooleanOption;
import com.pablop.survey.web.app.models.entity.Country;
import com.pablop.survey.web.app.models.entity.Person;
import com.pablop.survey.web.app.models.entity.Role;
import com.pablop.survey.web.app.models.entity.User;
import com.pablop.survey.web.app.services.CountryListService;
import com.pablop.survey.web.app.services.IRolesService;
import com.pablop.survey.web.app.services.IUserService;

@Controller
@RequestMapping("app/user")
@SessionAttributes("user")
public class NewUserController {

	@Autowired
	private IUserService iUserService;
	
	@Autowired
	private CountryListService countryListService;
	
	@Autowired
	private ICountryEditor countryEditor;
	
	@Autowired
	private IRolesService iRolesService;
	

	
	@Autowired
	ICountryEditor iCountryEditor;
	
	
	@Value("${text.indexController.userProfile.fieldUserProfileFirstName}")
	private String fieldUserProfileFirstName;

	@Value("${text.indexController.userProfile.fieldUserProfileEmail}")
	private String fieldUserProfileEmail;

	@Value("${text.indexController.userProfile.fieldUserProfileBirthday}")
	private String fieldUserProfileBirthday;

	@Value("${text.indexController.userProfile.fieldUserProfileLastName}")
	private String fieldUserProfileLastName;

	@Value("${text.indexController.userProfile.incomplete}")
	private String incomplete;

	@Value("${text.indexController.userProfile.fieldUserProfileCountry}")
	private String countryText;

	@Value("${text.NewUserController.title}")
	private String title;

	@Value("${text.duplicateUserException.title1}")
	private String title1;
	
	@Value("${text.duplicateUserException.title2}")
	private String title2;
	
	@Value("${text.indexController.userProfile.titleUserProfile}")
	private String titleUserProfile;
	
	@Value("${text.indexController.analyzedPeople.country}")
	private String country;
	
	@Value("${text.NewUserController.roleTitle}")
	private String roleTitle;
	
	@Value("${text.NewUserController.roles}")
	private String roles;
	
	@Value("${text.NewUserController.isActiveTitle}")
	private String isActiveTitle;	
	
	@Value("${text.NewUserController.isActiveYes}")
	private String isActiveYes;	
	
	@Value("${text.NewUserController.profileIsActiveYes}")
	private String profileIsActiveYes;	
	
	@Value("${text.NewUserController.isActiveNo}")
	private String isActiveNo;	
	
		
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Country.class, "country", (PropertyEditor) iCountryEditor);
//		binder.registerCustomEditor(User.class, "role", (PropertyEditor) iRoleEditor);		
		
	}
	
	@ModelAttribute("yesNoOptions")
	public ArrayList<BooleanOption> yesNoOptions() {
		ArrayList<BooleanOption> yesNoOptions = new ArrayList<BooleanOption>();
		yesNoOptions.add(new BooleanOption(isActiveYes, true));
		yesNoOptions.add(new BooleanOption(isActiveNo, false));
		return yesNoOptions;
	}

	@ModelAttribute("countryList")
	private List<Country> coutryList() {
		return countryListService.getCountryListObject();
	}

	@GetMapping("/newuser")
	public String newUser(Model model) {
		
		Boolean selected=false;
		ArrayList<Role> possibleRoles= iRolesService.findAllRoles();
		

		User user = new User();
		user.setUserActive(true);
		model.addAttribute("title", title);
		model.addAttribute("incomplete", incomplete);
		model.addAttribute("fieldUserProfileFirstName", fieldUserProfileFirstName);
		model.addAttribute("fieldUserProfileLastName", fieldUserProfileLastName);
		model.addAttribute("fieldUserProfileEmail", fieldUserProfileEmail);
		model.addAttribute("fieldUserProfileBirthday", fieldUserProfileBirthday);
		model.addAttribute("countryText", countryText);
		model.addAttribute("possibleRoles", possibleRoles);
		model.addAttribute("roleTitle", roleTitle);		
		model.addAttribute("user", user);
		model.addAttribute("isActiveTitle", isActiveTitle);		
		model.addAttribute("profileIsActiveYes", profileIsActiveYes);			
		model.addAttribute("isActiveNo", isActiveNo);	
		model.addAttribute("isActiveYes", isActiveYes);			
		model.addAttribute("selected", selected);			
		
		
		return "newuser";
	}

	@PostMapping("/newuser")
	public String loadUser(@Valid User user, BindingResult result, @RequestParam String email, Model model,
			SessionStatus status) {

		ArrayList<Role> possibleRoles= iRolesService.findAllRoles();
		
		if (result.hasErrors()) {
			model.addAttribute("title", title);
			model.addAttribute("incomplete", incomplete);
			model.addAttribute("fieldUserProfileFirstName", fieldUserProfileFirstName);
			model.addAttribute("fieldUserProfileLastName", fieldUserProfileLastName);
			model.addAttribute("fieldUserProfileEmail", fieldUserProfileEmail);
			model.addAttribute("fieldUserProfileBirthday", fieldUserProfileBirthday);
			model.addAttribute("countryText", countryText);
			model.addAttribute("roleTitle", roleTitle);
			model.addAttribute("roles", roles);	
			model.addAttribute("possibleRoles", possibleRoles);
			model.addAttribute("isActiveTitle", isActiveTitle);	
			model.addAttribute("profileIsActiveYes", profileIsActiveYes);
			model.addAttribute("isActiveNo", isActiveNo);	
			model.addAttribute("isActiveYes", isActiveYes);
			return "newuser";
		}

		iUserService.save(user);

//		EXAMPLE OF IMPLEMENTATION OF PROTOTYPE PATTERN
//		System.out.println("NewUserController original" + user);
//
//		User user2=null;
//		try {
//			user2 = (User) user.clone();
//		} catch (CloneNotSupportedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	 
//		System.out.println("NewUserController original"+ user2);
	
	
		
		User userSearched = iUserService.getUserByEmail(email);
		
		
		String userEmail = userSearched.getEmail();

		status.setComplete();

		return "redirect:/app/user/userprofile/"+ userEmail;
	}

	@GetMapping("/userprofile/{userEmail}")
	public String userProfile(@PathVariable String userEmail, Model model) {

		User user = iUserService.getUserByEmail(userEmail);
		ArrayList<Long> userRoles = user.getRoleIds();
		ArrayList<String> roleNames = new ArrayList<String>();

		for (Long id : userRoles) {
			String roleName = iRolesService.findRoleById(id).getRoleName();
			roleNames.add(roleName);

		}

		model.addAttribute("fieldUserProfileFirstName", fieldUserProfileFirstName);
		model.addAttribute("fieldUserProfileLastName", fieldUserProfileLastName);
		model.addAttribute("fieldUserProfileEmail", fieldUserProfileEmail);
		model.addAttribute("fieldUserProfileBirthday", fieldUserProfileBirthday);
		model.addAttribute("countryText", countryText);
		model.addAttribute("roleNames", roleNames);
		model.addAttribute("roles", roles);	
		model.addAttribute("user", user);
		model.addAttribute("titleUserProfile", titleUserProfile);	
		model.addAttribute("isActiveTitle", isActiveTitle);	
		model.addAttribute("isActiveYes", isActiveYes);			
		model.addAttribute("profileIsActiveYes", profileIsActiveYes);			
		
		
		
		return "userprofile";
	}
	
	
	
	
}
