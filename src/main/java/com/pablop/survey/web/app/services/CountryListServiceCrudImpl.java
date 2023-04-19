package com.pablop.survey.web.app.services;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pablop.survey.web.app.models.entity.Country;

@Service
@Primary
public class CountryListServiceCrudImpl implements CountryListService {

	@Autowired
	private ICountryListCrud iCountryListCrud;

	@Transactional(readOnly = true)
	@Override
	public Country searchCountryByName(String name) {

		List<Country> countryList = (List<Country>) iCountryListCrud.findAll();

		Country searched = null;
		int index = 0;

		if (!name.isEmpty()) {
			while (index < countryList.size() && searched == null) {
				if (countryList.get(index).getName().equalsIgnoreCase(name)) {
					searched = countryList.get(index);
				} else {
					index++;
				}
			}
		}
		return searched;

	}

	@Override
	@Transactional(readOnly = true)
	public List<Country> getCountryListObject() {
		// TODO Auto-generated method stub
		return (List<Country>) iCountryListCrud.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Country getCountrybyId(Long id) {

		return iCountryListCrud.findById(id).orElse(null);
	}

}
