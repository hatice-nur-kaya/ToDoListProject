package com.example.ToDoListProject.business.responses.tasks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdTaskResponse {
    private int id;
    private int userId;
    private int categoryId;
    private String title;
    private String statement;
    private LocalDate date;
    private String priorityLevel;
    private LocalDateTime reminderDateTime;
}