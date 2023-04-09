package com.pablop.survey.web.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="options_questions_category")
public class OptionQuestionCategory implements Serializable{


	private static final long serialVersionUID = 1L;
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@Column (name="category_option")
    private CategoryOption categoryOption;
	
	@Column (name="category_option_id")
	private Long category_id;
	
		
	@Column (name="option_name") 
	private String optionName;
	
	@Column (name="ranking_option")
	private int rankingOption;
	
	

	public OptionQuestionCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}
	
	

	public void setId(Long id) {
		this.id = id;
	}

	public CategoryOption getCategoryOption() {
		return categoryOption;
	}

	public void setCategoryOption(CategoryOption categoryOption) {
		this.categoryOption = categoryOption;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public Long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}

	public int getRankingOption() {
		return rankingOption;
	}

	public void setRankingOption(int rankingOption) {
		this.rankingOption = rankingOption;
	}

	@Override
	public String toString() {
		return "OptionQuestionCategory [id=" + id + ", category_id=" + category_id + ", optionName=" + optionName
				+ ", rankingOption=" + rankingOption + "]";
	}
    
	
	
	
	
    
	
}
