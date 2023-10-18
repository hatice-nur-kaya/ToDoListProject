package com.example.ToDoListProject.dataAccess.abstracts;

import com.example.ToDoListProject.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}