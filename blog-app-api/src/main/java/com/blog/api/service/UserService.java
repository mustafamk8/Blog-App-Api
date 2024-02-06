package com.blog.api.service;

import java.util.List;

import com.blog.api.payloads.UserDto;

public interface UserService {

	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user, Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto> getAllUsers();
	void deletUser(Integer userId);
	
}
