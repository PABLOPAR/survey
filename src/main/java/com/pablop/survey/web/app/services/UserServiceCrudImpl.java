package com.pablop.survey.web.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pablop.survey.web.app.models.entity.Country;
import com.pablop.survey.web.app.models.entity.User;

@Service
@Primary
public class UserServiceCrudImpl implements IUserService {

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

}
