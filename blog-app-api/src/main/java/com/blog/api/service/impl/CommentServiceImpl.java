package com.blog.api.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.api.entity.Category;
import com.blog.api.entity.Comment;
import com.blog.api.entity.Post;
import com.blog.api.exception.ResourceNotFoundException;
import com.blog.api.payloads.CategoryDto;
import com.blog.api.payloads.CommentDto;
import com.blog.api.repo.CommentRepo;
import com.blog.api.repo.PostRepo;
import com.blog.api.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		// TODO Auto-generated method stub
		
		Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","Id",postId));
		
		Comment comment = this.dtoToComment(commentDto);
		comment.setPost(post);
		Comment savedComment = this.commentRepo.save(comment);
		
		
		return this.commentToDto(savedComment);
	}

	@Override
	public void deleteComment(Integer commentId) {
		// TODO Auto-generated method stub
		Comment comment = this.commentRepo.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("Comment","Id",commentId));
		this.commentRepo.delete(comment);
	}

	public Comment dtoToComment(CommentDto commentDto) {
		
		Comment comment = this.modelMapper.map(commentDto, Comment.class);

		return comment;
	}
	
	public CommentDto commentToDto(Comment comment) {
		
		CommentDto commentDto = this.modelMapper.map(comment,CommentDto.class);
		return commentDto;

		
	}
	
	
}
