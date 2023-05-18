package com.pablop.survey.web.app.services;

import java.util.ArrayList;

import com.pablop.survey.web.app.models.entity.Role;

public interface IRolesService {

	
	public Role findRoleById(Long idRole);
	public ArrayList<Role> findAllRoles();
	
}
