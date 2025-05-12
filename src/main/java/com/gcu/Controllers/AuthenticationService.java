package com.gcu.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.Repository.UserRepository;
import com.gcu.models.UserModel;

@Service
public class AuthenticationService implements Authentication
{
    @Autowired
	private RegistrationService registrationService;
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean authenticate(String username, String password) {
        // we want this to pull from our userTable, running through each of the listed usernames. if a username returns true, then check if the password associated with it is correct
        List<UserModel> userList = registrationService.getAllUsers();
        boolean match = false;
        System.out.println();
        for(UserModel user : userList){
            System.out.println("Username:" + user.getUsername() + " Password:" + user.getPassword());
            if(username.equals(user.getUsername())){
                //match = true;
                System.out.println("Match found for username");
                if(password.equals(user.getPassword())){
                    System.out.println("Match found for password");
                    match = true;
                    break;
                }
            } 
        }
        System.out.println();
        //return "admin".equals(username) && "password".equals(password);
        return match;
    }
}
