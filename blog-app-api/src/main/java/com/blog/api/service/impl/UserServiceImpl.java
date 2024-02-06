package com.blog.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.api.exception.*;
import com.blog.api.entity.User;
import com.blog.api.payloads.UserDto;
import com.blog.api.repo.UserRepo;
import com.blog.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		
		
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		User updatedUser = this.userRepo.save(user);
		UserDto userDto1 = this.userToDto(updatedUser);
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
		UserDto userDto1 = this.userToDto(user);
		return userDto1;
	}

	@Override
	public List<UserDto> getAllUsers() {

		List<User> users =  this.userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deletUser(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
		this.userRepo.delete(user);

	}

	
	public User dtoToUser(UserDto userDto) {
		
		User user = this.modelMapper.map(userDto, User.class);
		
//		User u = new User();
//		u.setId(userDto.getId());
//		u.setName(userDto.getName());
//		u.setEmail(userDto.getEmail());
//		u.setAbout(userDto.getAbout());
//		u.setPassword(userDto.getPassword());
		return user;
	}
	
	public UserDto userToDto(User user) {
		
		UserDto userDto = this.modelMapper.map(user,UserDto.class);
		return userDto;
//		UserDto u = new UserDto();
//		u.setId(user.getId());
//		u.setName(user.getName());
//		u.setEmail(user.getEmail());
//		u.setAbout(user.getAbout());
//		u.setPassword(user.getPassword());
//		return u;
		
	}
	
}
