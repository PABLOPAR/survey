package com.pablop.survey.web.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;

import com.pablop.survey.web.app.services.IQuestionOptionService;

@Entity
@Table(name="category_options")
public class Category implements Serializable{


	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	
	@NotEmpty
	@Column(name="category_name")
	private String categoryName;
	
	
	public Category(Long id, @NotEmpty String categoryName) {
		super();
		this.id = id;
		this.categoryName = categoryName;
	}

	public Category() {

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
		return "Category [id=" + id + ", categoryName=" + categoryName + "]";
	}

	







	
	
}
