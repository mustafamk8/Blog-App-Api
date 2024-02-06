package com.blog.api.service;

import java.util.List;

import com.blog.api.entity.Post;
import com.blog.api.payloads.PostDto;
import com.blog.api.payloads.PostResponse;

public interface PostService {

	
	// create
	public PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	// update
	
	PostDto updatePost(PostDto postDto, Integer postId);
	
	// Delete
	
	void deletePost(Integer postId);
	// get all
	
	PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy,String sortDir);
	
	// get single
	PostDto getPostById(Integer postId);
	
	// get All post By category
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	// get all post by user
	List<PostDto> getPostByUser(Integer userId);
	
	// search posts
	List<PostDto> searchPosts(String keyword);
	
}
