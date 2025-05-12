package com.gcu.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.Repository.UserRepository;
import com.gcu.models.UserModel;

@Service
public class RegistrationServiceImpl implements RegistrationService{
	//Service should write to the users table
	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean registerUser(UserModel userModel) {
		//
		System.out.println("User Registered: " + userModel.getUsername());
		return true;
	}
	
	public List<UserModel> getAllUsers(){
		return (List<UserModel>)userRepository.findAll();
	}

	public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}

