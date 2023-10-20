package com.example.ToDoListProject.business.requests.tasks;

import lombok.Data;

@Data
public class CreatePageRequest {
    private String sortDirection;
    private String[] sortBy;
    private int pageNumber;
    private int pageSize;
}
