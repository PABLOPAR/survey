package com.pablop.survey.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping ("app")
public class IndexController {
	
	public String title = "Friends Survey, start enjoying different tests";

	@GetMapping(value={"/index", "/", "home"})
	public String index(Model model) {
		model.addAttribute("title",title);
		return "index";
		
	}


}
