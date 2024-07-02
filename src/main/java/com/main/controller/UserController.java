package com.main.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.main.model.User;
import com.main.service.UserService;


@RestController
public class UserController {
	
	
	@Autowired private UserService userService;
	
	@PostMapping("/save_user")
	public ResponseEntity<User> createUser(@RequestPart("user") String userJson,
			                               @RequestPart(value="prof",required = false) MultipartFile profile,
			                               @RequestPart(value="adhar",required = false) MultipartFile adharcard,
			                               @RequestPart(value="phot",required = false) MultipartFile photo
			                               )
	{
		
	
	  System.out.println(userJson);
	  
	
//	  System.out.println("Key Name="+profile.getName());
//	  System.out.println("Original File Name="+profile.getOriginalFilename());
//	  System.out.println("File Size in bytes="+profile.getSize());
	
//	  System.out.println("photo size : "+photo.getSize());
//	  System.out.println("photo name : "+photo.getName());
//	  System.out.println("photo image type : "+photo.getContentType());
//	  System.out.println("");
			
		User user = userService.saveDetails(userJson, profile, profile,adharcard);
		
	  
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
	}
	


}
