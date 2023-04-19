package com.pablop.survey.web.app.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class SupportFormImpl implements ISupportForm{

	private ArrayList<Long> ids=new ArrayList<Long>();
	
	
	@Override
	public void loadIdIntoArrayList(Long id) {
		if (id > 0) {
			ids.add(id);
		}
	}


	@Override
	public ArrayList<Long> getArrayListIds() {
		return getIds();
	}


	public ArrayList<Long> getIds() {
		return ids;
	}


	public void setIds(ArrayList<Long> ids) {
		this.ids = ids;
	}
	
	
	

}
