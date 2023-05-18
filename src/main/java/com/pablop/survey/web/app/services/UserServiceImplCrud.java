package com.pablop.survey.web.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pablop.survey.web.app.models.entity.User;

@Service
@Primary
public class UserServiceImplCrud implements IUserService {

	@Autowired
	private IUserServiceCrud iUserServiceCrud;
	
	@Override
	@Transactional (readOnly=true)
	public List<User> getUserList() {

		return (List<User>) iUserServiceCrud.findAll();
	}

	@Override
	@Transactional
	public void save(User user) {
		iUserServiceCrud.save(user);
		
	}

	@Override
	@Transactional (readOnly=true)
	public User getUserById(Long id) {

		return iUserServiceCrud.findById(id).orElse(null);
	}

	@Override
	@Transactional (readOnly=true)
	public User getUserByEmail(String email) {
		ArrayList<User> allUsers = (ArrayList<User>) getUserList();

		int index = 0;
		User userSearched = null;

		while (index < allUsers.size() && userSearched == null) {
			if (allUsers.get(index).getEmail().equalsIgnoreCase(email)) {
				userSearched = allUsers.get(index);

			} else {
				index++;
			}
		}
		return userSearched;
	}

}
