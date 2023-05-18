package com.pablop.survey.web.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;

import com.pablop.survey.web.app.models.entity.Role;
import com.pablop.survey.web.app.services.IRolesService;

public class CountryEditor extends PropertyEditorSupport implements IRoleEditor {

	@Autowired
	private IRolesService iRolesService;
	
	
	@Override
	public void setAsText(String roleId) throws IllegalArgumentException {

		if (!roleId.isEmpty()) {

			try {
				Long idSearched = Long.parseLong(roleId);
				Role roleSerched = iRolesService.findRoleById(idSearched);
				if (roleSerched != null) {
					setValue(roleSerched);
				}

			} catch (NumberFormatException e) {
			}
		}

	}
	
	@Override
	public void idLongToRole(String idRole) {
		setAsText(idRole);
	}

	
}
