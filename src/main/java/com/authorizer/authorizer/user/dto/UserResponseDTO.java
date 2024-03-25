package com.authorizer.authorizer.user.dto;

import com.authorizer.authorizer.user.User;

public record UserResponseDTO(Long id, String username, String password) {
    public UserResponseDTO(User user) {
        this(user.getId(), user.getUsername(), user.getPassword());
    }
}