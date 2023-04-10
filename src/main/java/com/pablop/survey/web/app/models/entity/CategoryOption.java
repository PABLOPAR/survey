package com.pablop.survey.web.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="category_options")
public class CategoryOption implements Serializable{


	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	
	@NotEmpty
	@Column(name="category_name")
	private String categoryName;
	
	
	
	
	public CategoryOption() {
	}
	
	

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "CategoryOption [id=" + id + ", categoryName=" + categoryName + "]";
	}




	
	
}
