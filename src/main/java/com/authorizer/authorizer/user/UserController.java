package com.authorizer.authorizer.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authorizer.authorizer.user.dto.UserRequestDTO;
import com.authorizer.authorizer.user.dto.UserResponseDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    
    private final UserService userService;
    
    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@RequestBody UserRequestDTO user) {
        UserResponseDTO userData = userService.create(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userData);
    }
}
