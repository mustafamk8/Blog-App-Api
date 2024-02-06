package com.blog.api.service;

import java.util.List;

import com.blog.api.payloads.CategoryDto;

public interface CategoryService {

	
	//create
	public CategoryDto createCategory(CategoryDto categoryDto);
	
	//update
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryid);
	
	//delete
	public void deleteCategory(Integer categoryId);
	
	//get
	
	public CategoryDto getCategory(Integer categoryId);
	
	// get all
	public List<CategoryDto> getAllCategory();
	
	
}
