package com.blog.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blog.api.entity.Category;
import com.blog.api.exception.ResourceNotFoundException;
import com.blog.api.payloads.CategoryDto;
import com.blog.api.repo.CategoryRepo;
import com.blog.api.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		// TODO Auto-generated method stub
		
		Category category = this.dtoToCategory(categoryDto);
		Category savedCategory = this.categoryRepo.save(category);
		
		return this.categoryToDto(savedCategory);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryid) {
		// TODO Auto-generated method stub
		Category category = this.categoryRepo.findById(categoryid).orElseThrow(()-> new ResourceNotFoundException("Category","Id",categoryid));
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDesc(categoryDto.getCategoryDesc());
		
		Category updatedCategory = this.categoryRepo.save(category);
		CategoryDto categoryDto1 = this.categoryToDto(updatedCategory);
		
		return categoryDto1;
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","Id",categoryId));
		this.categoryRepo.delete(category);

	}

	@Override
	public CategoryDto getCategory(Integer categoryid) {
		// TODO Auto-generated method stub
		Category category = this.categoryRepo.findById(categoryid).orElseThrow(()-> new ResourceNotFoundException("Category","Id",categoryid));
		CategoryDto categoryDto = this.categoryToDto(category);
		return categoryDto;
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> categories =  this.categoryRepo.findAll();
		List<CategoryDto> categoryDtos = categories.stream().map(cat->this.categoryToDto(cat)).collect(Collectors.toList());
		return categoryDtos;
	}
	
	
	public Category dtoToCategory(CategoryDto categoryDto) {
		
		Category category = this.modelMapper.map(categoryDto, Category.class);

		return category;
	}
	
	public CategoryDto categoryToDto(Category category) {
		
		CategoryDto categoryDto = this.modelMapper.map(category,CategoryDto.class);
		return categoryDto;

		
	}
	

}
