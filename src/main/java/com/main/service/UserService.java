package com.main.service;

import org.springframework.web.multipart.MultipartFile;

import com.main.model.User;

public interface UserService {

	public User saveDetails(String userJson, MultipartFile profile, MultipartFile adharcard, MultipartFile adharcard2);
	
	

}
