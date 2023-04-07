package com.pablop.survey.web.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="question_options")
public class QuestionOption implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	@Column (name="option_name")
	private String optionName;
	
	@NotNull
	@Column(name="option_category")
	private String optionCategory;
	

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	public QuestionOption(String optionName, String optionCategory) {
		super();
		this.optionName = optionName;
		this.optionCategory = optionCategory;
	}

	public QuestionOption() {
		super();

	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public String getOptionCategory() {
		return optionCategory;
	}

	public void setOptionCategory(String optionCategory) {
		this.optionCategory = optionCategory;
	}
	
	
	
}
