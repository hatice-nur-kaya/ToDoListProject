package com.example.ToDoListProject.business.responses.reminder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateReminderResponse {
    private int id;
    private String message;
    private LocalDateTime reminderDateTime;
    private int taskId;
}
