package com.example.ToDoListProject.business.abstracts;

import com.example.ToDoListProject.business.requests.tasks.CreateTaskRequest;
import com.example.ToDoListProject.business.requests.tasks.DeleteTaskRequest;
import com.example.ToDoListProject.business.requests.tasks.UpdateTaskRequest;
import com.example.ToDoListProject.business.responses.tasks.*;
import com.example.ToDoListProject.core.results.DataResult;

import java.util.List;

public interface TaskService {
    DataResult<List<GetAllTaskResponse>> getAll();

    DataResult<GetByIdTaskResponse> getById(int id);

    DataResult<CreateTaskResponse> add(CreateTaskRequest request);

    DataResult<UpdateTaskResponse> update(UpdateTaskRequest request);

    DataResult<DeleteTaskResponse> delete(DeleteTaskRequest request);
}