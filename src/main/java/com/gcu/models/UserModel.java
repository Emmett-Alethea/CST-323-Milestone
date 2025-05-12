package com.gcu.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Table("users")//maps table to DB
public class UserModel {
    @Id
    Long id;
    // User personal details
    @Column("firstname")
    @NotNull(message="Please enter a first name")
    @Size(min=1, max=32, message="First Name must be between 1 and 32 characters")
    private String firstName;

    @Column("lastname")
    @NotNull(message="Please enter a last name")
    @Size(min=1, max=32, message="Last Name must be between 1 and 32 characters")
    private String lastName;

    // User registration/login details
    @Column("username")
    @NotNull(message="Username required")
    @Size(min=1, max=32, message="Username must be between 1 and 32 characters")
    private String username;

    @Column("password")
    @NotNull(message="Password required")
    @Size(min=1, max=32, message="Password must be between 1 and 32 characters")
    private String password;

    @Column("email")
    @NotNull(message="Please enter an email address")
    @Size(min=1, max=32, message="Email must be between 1 and 64 characters")
    @Email(message="Valid email is required")
    private String email;

    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getUsername(){return username;}
    public void setUsername(String userName){this.username = userName;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}
}
