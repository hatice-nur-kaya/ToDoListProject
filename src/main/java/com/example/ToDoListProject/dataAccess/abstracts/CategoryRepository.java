package com.example.ToDoListProject.dataAccess.abstracts;

import com.example.ToDoListProject.entities.Category;
import com.example.ToDoListProject.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findByName(String nameKeyword);
}