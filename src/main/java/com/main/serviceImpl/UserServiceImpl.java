package com.main.serviceImpl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.model.User;
import com.main.repository.UserRepository;
import com.main.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired private UserRepository userRepository;

	@Override
	public User saveDetails(String userJson, MultipartFile profile, MultipartFile adharcard, MultipartFile adharcard2) {

		ObjectMapper mapper = new ObjectMapper();
		
		User u = null;
		
		try {
			u = mapper.readValue(userJson, User.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if(profile!=null) {
				u.setProfileImage(profile.getBytes());
			}
			
			if(adharcard!=null) {
				u.setAdharCard(adharcard.getBytes());
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		User dbUser = userRepository.save(u);
		return dbUser;
	}

}
