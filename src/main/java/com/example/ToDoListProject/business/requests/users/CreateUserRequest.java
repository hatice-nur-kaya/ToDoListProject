package com.example.ToDoListProject.business.requests.users;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String avatar;
}