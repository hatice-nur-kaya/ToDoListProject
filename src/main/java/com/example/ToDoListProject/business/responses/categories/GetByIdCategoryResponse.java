package com.example.ToDoListProject.business.responses.categories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdCategoryResponse {
    private String id;
    private String name;
}