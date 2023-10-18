package com.example.ToDoListProject.dataAccess.abstracts;

import com.example.ToDoListProject.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}