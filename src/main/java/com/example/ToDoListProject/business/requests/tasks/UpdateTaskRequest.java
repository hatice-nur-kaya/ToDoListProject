package com.example.ToDoListProject.business.requests.tasks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTaskRequest {
    private int id;
    private String title;
    private String statement;
    private LocalDate date;
    private String priorityLevel;
    private int categoryId;
    private int userId;
}