package com.gcu.Controllers;

import java.util.List;

import com.gcu.models.UserModel;

public interface RegistrationService {
	
	boolean registerUser (UserModel userModel);
	public List<UserModel> getAllUsers();
	public void deleteUser(Long id);

}
