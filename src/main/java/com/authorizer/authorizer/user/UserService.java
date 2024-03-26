package com.authorizer.authorizer.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.authorizer.authorizer.user.dto.UserRequestDTO;
import com.authorizer.authorizer.user.dto.UserResponseDTO;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public ResponseEntity<UserResponseDTO> create(UserRequestDTO userData) {
        if(userRepository.findByUsername(userData.username()) != null) {
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(userData.password());
        UserRequestDTO newUserRequestDTO = new UserRequestDTO(userData.username(), encryptedPassword, userData.role());

        User newUser = new User(newUserRequestDTO);
        userRepository.save(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(new UserResponseDTO(newUser));
    }
}