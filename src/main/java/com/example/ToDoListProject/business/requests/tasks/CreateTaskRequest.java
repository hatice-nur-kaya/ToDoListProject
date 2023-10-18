package com.example.ToDoListProject.business.requests.tasks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTaskRequest {
    private String work;
    private String title;
    private String statement;
    private LocalDate date;
    private String priorityLevel;
}