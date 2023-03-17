package com.pablop.survey.web.app.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import com.pablop.survey.web.app.models.entity.Country;
import com.pablop.survey.web.app.models.entity.PeopleAnalyzed;

@Service("peopleImplementationLocale")
@RequestScope
@Primary
public class PeopleServiceImpl implements PeopleService{
	
	List<PeopleAnalyzed> peopleAnalyzedList;
	List<Country> countryListObject;
	
	public PeopleServiceImpl() {
		
	    String mikeBirthS="25/01/1980"; 
	    Date mikeBirth=null;
	    
	    
	    try {
			Date mikeBirth2=new SimpleDateFormat("dd/MM/yyyy").parse(mikeBirthS);
			mikeBirth=mikeBirth2;
						
		} catch (ParseException e) {
		// TODO Auto-generated catch block
			mikeBirth=null;
			e.printStackTrace();
		}  

	    Country countryMike= new Country ("Antarctica");
	    Country countryJhon= new Country ("Austria");
	    Country countryClaude= new Country ("Spain");
	    Country countrySmith= new Country ("Austria");	    
	    
		this.peopleAnalyzedList = new ArrayList<PeopleAnalyzed>();
		
		
		PeopleAnalyzed mike=new PeopleAnalyzed("Mike", "mike@gmail.com");
		PeopleAnalyzed smith=new PeopleAnalyzed("Jeff", "Jeff@gmail.com");
		PeopleAnalyzed jhon=new PeopleAnalyzed("Jhon", "Jhon@gmail.com");
		PeopleAnalyzed claude=new PeopleAnalyzed( "Claude", "Claude@gmail.com");
		
				


		
		mike.setBirthday(mikeBirth);
		mike.setLastName("Dior");
		mike.setCountry(countryMike);
	
		
		smith.setLastName("Smith");
		smith.setCountry(countrySmith);
		

		claude.setCountry(countryClaude);

		
		jhon.setCountry(countryJhon);
	

		peopleAnalyzedList.add(mike);
		peopleAnalyzedList.add(jhon);
		peopleAnalyzedList.add(claude);
		peopleAnalyzedList.add(smith);		
		
		
		this.countryListObject= createCountryList();
		
	}

	@Override
	public List<PeopleAnalyzed> peopleListAnalized() {
		return peopleAnalyzedList;
	}

	@Override
	public PeopleAnalyzed analyzedByEmail(String email) {

		PeopleAnalyzed peopleSearched = null;
		int index = 0;

		if (!email.isEmpty()) {


			while (peopleSearched == null && peopleAnalyzedList.size() > index) {
				if (peopleAnalyzedList.get(index).getEmail().equalsIgnoreCase(email)) {
					peopleSearched = peopleAnalyzedList.get(index);
					
				} else {
					index++;
				}
			}
		}

		return peopleSearched;
	}

	public List<PeopleAnalyzed> addPeopleAnalyzed(PeopleAnalyzed newPeople) {

		if (newPeople != null) {

			peopleAnalyzedList.add(newPeople);

		}
		return peopleAnalyzedList;

	}

	public List<PeopleAnalyzed> getPeopleAnalyzedList() {
		return peopleAnalyzedList;
	}

	public void setPeopleAnalyzedList(List<PeopleAnalyzed> peopleAnalyzedList) {
		this.peopleAnalyzedList = peopleAnalyzedList;
	}

	@Override
	public String toString() {
		return "PeopleServiceImpl [peopleAnalyzedList=" + peopleAnalyzedList + "]";
	}

	@Override
	public List<String> countryList() {
		return Arrays.asList("Afghanistan", "Aland Islands", "Albania", "Algeria", "American Samoa", "Andorra",
				"Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia",
				"Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize",
				"Benin", "Bermuda", "Bhutan", "Bolivia (Plurinational State of)", "Bonaire, Sint Eustatius and Saba",
				"Bosnia and Herzegovina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory",
				"Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cabo Verde", "Cambodia", "Cameroon",
				"Canada", "Cayman Islands", "Central African Republic", "Chad", "Chile", "China", "Christmas Island",
				"Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo", "Congo (Democratic Republic of the)",
				"Cook Islands", "Costa Rica", "Cote d Ivoire", "Croatia", "Cuba", "Curacao", "Cyprus", "Czech Republic",
				"Denmark", "Djibouti", "Dominica", "Dominican Republic", "Ecuador", "Egypt", "El Salvador",
				"Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Falkland Islands (Malvinas)", "Faroe Islands",
				"Fiji", "Finland", "France", "French Guiana", "French Polynesia", "French Southern Territories",
				"Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada",
				"Guadeloupe", "Guam", "Guatemala", "Guernsey", "Guinea", "Guinea-Bissau", "Guyana", "Haiti",
				"Heard Island and McDonald Islands", "Holy See", "Honduras", "Hong Kong", "Hungary", "Iceland", "India",
				"Indonesia", "Iran (Islamic Republic of)", "Iraq", "Ireland", "Isle of Man", "Israel", "Italy",
				"Jamaica", "Japan", "Jersey", "Jordan", "Kazakhstan", "Kenya", "Kiribati",
				"Korea (Democratic Peoples Republic of)", "Korea (Republic of)", "Kuwait", "Kyrgyzstan",
				"Lao Peoples Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein",
				"Lithuania", "Luxembourg", "Macao", "Macedonia (the former Yugoslav Republic of)", "Madagascar",
				"Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania",
				"Mauritius", "Mayotte", "Mexico", "Micronesia (Federated States of)", "Moldova (Republic of)", "Monaco",
				"Mongolia", "Montenegro", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal",
				"Netherlands", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue",
				"Norfolk Island", "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau",
				"Palestine, State of", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn",
				"Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda",
				"Saint Barthelemy", "Saint Helena, Ascension and Tristan da Cunha", "Saint Kitts and Nevis",
				"Saint Lucia", "Saint Martin (French part)", "Saint Pierre and Miquelon",
				"Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia",
				"Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Sint Maarten (Dutch part)", "Slovakia",
				"Slovenia", "Solomon Islands", "Somalia", "South Africa",
				"South Georgia and the South Sandwich Islands", "South Sudan", "Spain", "Sri Lanka", "Sudan",
				"Suriname", "Svalbard and Jan Mayen", "Swaziland", "Sweden", "Switzerland", "Syrian Arab Republic",
				"Taiwan, Province of China[a]", "Tajikistan", "Tanzania, United Republic of", "Thailand", "Timor-Leste",
				"Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan",
				"Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates",
				"United Kingdom of Great Britain and Northern Ireland", "United States of America",
				"United States Minor Outlying Islands", "Uruguay", "Uzbekistan", "Vanuatu",
				"Venezuela (Bolivarian Republic of)", "Viet Nam", "Virgin Islands (British)", "Virgin Islands (U.S.)",
				"Wallis and Futuna", "Western Sahara", "Yemen", "Zambia", "Zimbabwe");
	}

	public List<Country> createCountryList() {

		countryListObject = new ArrayList<Country>();

		List<String> source = countryList();

		for (String countryName : source) {
			countryListObject.add(new Country(countryName));
		}

		return countryListObject;
	}
	



	@Override
	public List<Country> countryListObject() {
		// TODO Auto-generated method stub
		return countryListObject;
	}

	@Override
	public Country searchCountryByName(String name) {
		Country searched = null;
		int index = 0;

		if (name != null && !name.isEmpty()) {

			while (countryListObject.size() > index && searched == null) {

				if (countryListObject.get(index).getName().equalsIgnoreCase(name)) {
					searched = countryListObject.get(index);

				} else {
					index++;
				}
				;
			}
		}
		return searched;
	};

	public List<Country> getCountryListObject() {
		return countryListObject;
	}

	public void setCountryListObject(List<Country> countryListObject) {
		this.countryListObject = countryListObject;
	}


	

}
