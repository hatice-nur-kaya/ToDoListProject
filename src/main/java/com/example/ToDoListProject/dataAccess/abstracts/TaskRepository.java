package com.example.ToDoListProject.dataAccess.abstracts;

import com.example.ToDoListProject.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findByTitleContainingOrStatementContaining(String titleKeyword,String statementKeyword);
}