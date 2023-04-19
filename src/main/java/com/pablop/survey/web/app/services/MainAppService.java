package com.pablop.survey.web.app.services;

import java.util.ArrayList;

import com.pablop.survey.web.app.models.entity.User;

public interface MainAppService {

	
	public boolean addUser(User user);
	public User searchUserByEmail(String email);
	public ArrayList<User> getUserList();
	
}
