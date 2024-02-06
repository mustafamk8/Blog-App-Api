package com.blog.api.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.api.entity.Category;
import com.blog.api.entity.Post;
import com.blog.api.entity.User;

public interface PostRepo extends JpaRepository<Post, Integer>{

	
	List<Post> findByUser(User user);
	
	List<Post> findByCategory(Category category);
	
	List<Post> findByTitleContaining(String title);
	
	//@Query("select p from Post where p.title like :key")
	//List<Post> findByTitle(@Param("key")String title);
	// %key%
}
