package com.blog.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.api.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
