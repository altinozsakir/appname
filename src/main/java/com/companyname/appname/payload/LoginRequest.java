package com.companyname.appname.payload;

import javax.validation.constraints.NotBlank;

public class LoginRequest {

    @NotBlank
    private String usernameOrEmail;

    @NotBlank
    private String password;

    public String getUsernameOrEmail(){
        return this.usernameOrEmail;
    }

    public String getPassword(){
        return this.password;
    }

    public void setUsernameOrEmail(String usernameOrEmail){
        this.usernameOrEmail = usernameOrEmail;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
