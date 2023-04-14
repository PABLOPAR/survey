package com.pablop.survey.web.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity(name="options_questions_category")
public class OptionQuestionCategory implements Serializable{


	private static final long serialVersionUID = 1L;
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
//	@Column (name="category_option")
//    private CategoryOption categoryOption;
	
	@Column (name="category_option_id")
    private Long categoryOptionId;
	
	@NotEmpty
	@Column (name="option_name") 
	private String optionName;
	
	@Min(value=1)
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


	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}



	public int getRankingOption() {
		return rankingOption;
	}




	public Long getCategoryOptionId() {
		return categoryOptionId;
	}

	public void setCategoryOptionId(Long categoryOptionId) {
		this.categoryOptionId = categoryOptionId;
	}

	@Override
	public String toString() {
		return "OptionQuestionCategory [id=" + id + ", categoryOptionId=" + categoryOptionId + ", optionName="
				+ optionName + ", rankingOption=" + rankingOption + "]";
	}

	public void setRankingOption(int rankingOption) {
		this.rankingOption = rankingOption;
	}


    
	
	
	
	
    
	
}
