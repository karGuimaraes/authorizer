package com.authorizer.authorizer.user.dto;

import com.authorizer.authorizer.user.enums.UserRole;

public record UserRequestDTO(
    String username,
    String password,
    UserRole role)
{
}
