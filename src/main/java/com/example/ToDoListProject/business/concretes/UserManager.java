package com.example.ToDoListProject.business.concretes;

import com.example.ToDoListProject.business.abstracts.UserService;
import com.example.ToDoListProject.business.requests.users.CreateUserRequest;
import com.example.ToDoListProject.business.requests.users.DeleteUserRequest;
import com.example.ToDoListProject.business.requests.users.UpdateUserRequest;
import com.example.ToDoListProject.business.responses.users.*;
import com.example.ToDoListProject.core.mapping.ModelMapperService;
import com.example.ToDoListProject.core.results.DataResult;
import com.example.ToDoListProject.core.results.SuccessDataResult;
import com.example.ToDoListProject.dataAccess.abstracts.UserRepository;
import com.example.ToDoListProject.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
    private final UserRepository _userRepository;
    private final ModelMapperService _modelMapperService;

    @Override
    public DataResult<List<GetAllUserResponse>> getAll() {
        List<User> users = _userRepository.findAll();
        List<GetAllUserResponse> responses = users.stream().map(user -> _modelMapperService
                .forRequest().map(user, GetAllUserResponse.class)).toList();
        return new SuccessDataResult<List<GetAllUserResponse>>(responses, "Success");
    }

    @Override
    public DataResult<GetByIdUserResponse> getById(int id) {
        User user = _userRepository.findById(id).get();
        GetByIdUserResponse response = _modelMapperService.forResponse().map(user, GetByIdUserResponse.class);
        return new SuccessDataResult<GetByIdUserResponse>(response, "Success");
    }

    @Override
    public DataResult<CreateUserResponse> add(CreateUserRequest request) {
        User user = _modelMapperService.forRequest().map(request, User.class);
        _userRepository.save(user);
        CreateUserResponse response = _modelMapperService.forResponse().map(user, CreateUserResponse.class);
        return new SuccessDataResult<CreateUserResponse>(response, "Success");
    }

    @Override
    public DataResult<UpdateUserResponse> update(UpdateUserRequest request) {
        User user = _modelMapperService.forRequest().map(request, User.class);
        _userRepository.save(user);
        UpdateUserResponse response = _modelMapperService.forResponse().map(user, UpdateUserResponse.class);
        return new SuccessDataResult<UpdateUserResponse>(response, "Success");
    }

    @Override
    public DataResult<DeleteUserResponse> delete(DeleteUserRequest request) {
        User user = _modelMapperService.forRequest().map(request, User.class);
        _userRepository.delete(user);
        DeleteUserResponse response = _modelMapperService.forResponse().map(user, DeleteUserResponse.class);
        return new SuccessDataResult<DeleteUserResponse>(response, "Success");
    }
}