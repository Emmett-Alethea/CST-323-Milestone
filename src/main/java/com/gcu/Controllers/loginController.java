package com.gcu.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import com.gcu.models.loginModel;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class loginController {

    private final Authentication authentication;

    // Constructor injection of Authentication
    @Autowired
    public loginController(Authentication authentication)
    {
        this.authentication = authentication;
    }

    @GetMapping("/login")
    public String display(Model model) {
        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new loginModel());
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(@Valid loginModel loginModel, BindingResult bindingResult, Model model) {

        System.out.println();
        System.out.println("Entered username:" + loginModel.getUsername() + " and password:" + loginModel.getPassword());
        System.out.println();
        if(bindingResult.hasErrors()){
            model.addAttribute("title", "Login");
            System.out.println("Binding error");
            return "login";
        }
        
        boolean isAuthenticated = authentication.authenticate(loginModel.getUsername(), loginModel.getPassword());

    if (isAuthenticated)
    {
        return "redirect:/"; // redirect to the home page after successful login
    } else {
        model.addAttribute("error", "Invalid username or password");
        model.addAttribute("title", "Login");
        return "login"; // Return to login page if authentication fails
    }
    }
}
