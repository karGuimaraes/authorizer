package com.authorizer.authorizer.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.authorizer.authorizer.role.Role;
import com.authorizer.authorizer.user.dto.UserRequestDTO;

import java.util.List;

@Entity(name = "users")
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @ManyToMany
    private List<Role> roles;

    public User(UserRequestDTO data) {
        this.username = data.getUsername();
        this.password = data.getPassword();
    }
}
