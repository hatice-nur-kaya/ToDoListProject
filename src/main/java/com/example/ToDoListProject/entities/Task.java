package com.example.ToDoListProject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tasks")
@Inheritance(strategy = InheritanceType.JOINED)
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "work")
    private String work;
    @Column(name = "title")
    private String title;
    @Column(name = "statement")
    private String statement;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "priorityLevel")
    private String priorityLevel;
}