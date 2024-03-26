package com.authorizer.authorizer.user.dto;

import com.authorizer.authorizer.user.User;
import com.authorizer.authorizer.user.enums.UserRole;

public record UserResponseDTO(String id, String username, String password, UserRole role) {
    public UserResponseDTO(User user) {
        this(user.getId(), user.getUsername(), user.getPassword(), user.getRole());
    }
}