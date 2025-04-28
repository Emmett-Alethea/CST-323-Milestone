package com.gcu.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.models.UserModel;

import jakarta.validation.Valid;

@Controller
public class RegisterUserController {
	
	@Autowired
	private RegistrationService registrationService; // dependency injection

    @GetMapping("/register") // full mapping is /request/
    public String display(Model model){
        model.addAttribute("title", "Registration Form");
        model.addAttribute("userModel", new UserModel());
        return "register";
    }

    @PostMapping("/doRegister")
    public String doRegister(@Valid UserModel userModel, BindingResult bindingResult, Model model){
        System.out.println(String.format("Form: User with Username of %s and Password of %s created", userModel.getUsername(), userModel.getPassword()));

        if(bindingResult.hasErrors()){
            model.addAttribute("title", "Registration Form");
            return "register";
        }
        
        //Call the service to register the user
        boolean isRegistered = registrationService.registerUser(userModel);
        if (isRegistered) {
        	return "redirect:/"; //redirects users to home page
        }

        //Figure out how to add the new user to the list of existing users and later the database
        model.addAttribute("message", "Registration failed.");
        return "redirect:/"; //redirect back to registration page if fails
    }
}
