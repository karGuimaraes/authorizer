package com.authorizer.authorizer.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.authorizer.authorizer.user.dto.UserRequestDTO;
import com.authorizer.authorizer.user.dto.UserResponseDTO;

@Service
public class UserService {
    private String encodePassword(String password) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    public UserResponseDTO create(UserRequestDTO userRequestDTO) {
        User existUser = userRepository.findByUsername(userRequestDTO.getUsername());
        if (existUser != null) {
            throw new IllegalArgumentException("User already exists");
        }
        User userData = new User(null, userRequestDTO.getUsername(), userRequestDTO.getPassword(), null);

        String encodedPassword = encodePassword(userRequestDTO.getPassword());
        userData.setPassword(encodedPassword);
        
        userRepository.save(userData);
        
        return new UserResponseDTO(userData.getId(), userData.getUsername(), encodedPassword);
    }
}