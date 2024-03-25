package com.authorizer.authorizer.user.dto;

import org.springframework.stereotype.Component;

@Component
public class UserRequestDTO {
    private String username;
    private String password;
    
    public UserRequestDTO() {
    }
    
    public UserRequestDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
