package com.example.ToDoListProject.business.abstracts;

import com.example.ToDoListProject.business.requests.users.CreateUserRequest;
import com.example.ToDoListProject.business.requests.users.DeleteUserRequest;
import com.example.ToDoListProject.business.requests.users.UpdateUserRequest;
import com.example.ToDoListProject.business.responses.users.*;
import com.example.ToDoListProject.core.results.DataResult;

import java.util.List;

public interface UserService {
    DataResult<List<GetAllUserResponse>> getAll();

    DataResult<GetByIdUserResponse> getById(int id);

    DataResult<CreateUserResponse> add(CreateUserRequest request);

    DataResult<UpdateUserResponse> update(UpdateUserRequest request);

    DataResult<DeleteUserResponse> delete(DeleteUserRequest request);
}