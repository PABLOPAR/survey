package com.pablop.survey.web.app.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.pablop.survey.web.app.models.entity.Role;

@Component
@Primary
public class RoleServiceCrudImpl implements IRolesService{
	
	@Autowired
	private IRoleCrud iRolesCrud;
	
	@Override
	public Role findRoleById(Long idRole) {
		
		return iRolesCrud.findById(idRole).orElse(null);
	}
	
	@Override
	public ArrayList<Role> findAllRoles(){
		
		return (ArrayList<Role>) iRolesCrud.findAll();
		
	};
	
	
	
	
	

}
