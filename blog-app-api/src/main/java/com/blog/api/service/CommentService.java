package com.blog.api.service;

import com.blog.api.payloads.CommentDto;

public interface CommentService {

	public CommentDto createComment(CommentDto commentDto , Integer postId);
	
	public void deleteComment(Integer commentId);
	
}
