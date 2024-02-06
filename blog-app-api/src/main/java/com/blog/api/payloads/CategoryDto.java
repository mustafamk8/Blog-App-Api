package com.blog.api.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CategoryDto {

	private Integer id;
	
	@NotBlank
	@Size(min=4, message="minimum size of category title is 4 char")
	private String categoryTitle;
	
	@NotBlank
	@Size(min=10, message="Size must be greater than 10 chars")
	private String categoryDesc;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategoryTitle() {
		return categoryTitle;
	}
	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}
	public String getCategoryDesc() {
		return categoryDesc;
	}
	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}
	public CategoryDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
