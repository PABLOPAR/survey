package com.pablop.survey.web.app.services;

import com.pablop.survey.web.app.models.entity.User;

public interface MainAppService {

	
	public User addUser(User user);
	public User searchUserByEmail(String email);
	
}
