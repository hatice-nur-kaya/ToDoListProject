package com.example.ToDoListProject.business.abstracts;

import com.example.ToDoListProject.business.requests.categories.CreateCategoryRequest;
import com.example.ToDoListProject.business.requests.categories.DeleteCategoryRequest;
import com.example.ToDoListProject.business.requests.categories.UpdateCategoryRequest;
import com.example.ToDoListProject.business.responses.categories.*;
import com.example.ToDoListProject.core.results.DataResult;

import java.util.List;

public interface CategoryService {
    DataResult<List<GetAllCategoryResponse>> getAll();

    DataResult<GetByIdCategoryResponse> getById(int id);

    DataResult<CreateCategoryResponse> add(CreateCategoryRequest request);

    DataResult<UpdateCategoryResponse> update(UpdateCategoryRequest request);

    DataResult<DeleteCategoryResponse> delete(DeleteCategoryRequest request);
}