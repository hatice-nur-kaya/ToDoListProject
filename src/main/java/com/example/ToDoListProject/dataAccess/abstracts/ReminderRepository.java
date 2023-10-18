package com.example.ToDoListProject.dataAccess.abstracts;

import com.example.ToDoListProject.entities.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReminderRepository extends JpaRepository<Reminder, Integer> {
}