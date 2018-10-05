package com.companyname.appname.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignUpRequest {

    @NotBlank
    @Size(min=3, max=50)
    private String name;

    @NotBlank
    @Size(min=3,max = 50)
    private String surname;

    @NotBlank
    @Size(min=3,max=50)
    private String username;

    @NotBlank
    @Email
    @Size(max=100)
    private String email;

    @NotBlank
    @Size(min=6,max=100)
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}