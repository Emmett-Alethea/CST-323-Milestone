package com.gcu.Controllers;

import org.springframework.stereotype.Service;

import com.gcu.models.UserModel;

@Service
public class RegistrationServiceImpl implements RegistrationService{
	
	@Override
	public boolean registerUser(UserModel userModel) {
		//
		System.out.println("User Registered: " + userModel.getUsername());
		return true;
	}
	

}
