package com.pablop.survey.web.app.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
			
		
		
		
		return "forward:app/survey/peopleanalyzed";
		
	}
	
}
