package com.example.ToDoListProject.dataAccess.abstracts;

import com.example.ToDoListProject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}