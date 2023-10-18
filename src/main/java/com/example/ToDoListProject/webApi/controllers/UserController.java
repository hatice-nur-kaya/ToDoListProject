package com.example.ToDoListProject.webApi.controllers;

import com.example.ToDoListProject.business.abstracts.UserService;
import com.example.ToDoListProject.business.requests.users.CreateUserRequest;
import com.example.ToDoListProject.business.requests.users.DeleteUserRequest;
import com.example.ToDoListProject.business.requests.users.UpdateUserRequest;
import com.example.ToDoListProject.business.responses.users.CreateUserResponse;
import com.example.ToDoListProject.business.responses.users.GetByIdUserResponse;
import com.example.ToDoListProject.business.responses.users.UpdateUserResponse;
import com.example.ToDoListProject.core.results.DataResult;
import com.example.ToDoListProject.core.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController extends BaseController {
    private final UserService _userService;

    @GetMapping("getall")
    public ResponseEntity<?> getAll() {
        return GetDataResponseOnlyResultData(_userService.getAll());
    }

    @GetMapping("getbyid/{id}")
    public DataResult<GetByIdUserResponse> getById(@PathVariable int id) {
        return _userService.getById(id);
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody CreateUserRequest request) {
        DataResult<CreateUserResponse> result = _userService.add(request);
        return GetDataResponseOnlyResultData(_userService.getAll());
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid UpdateUserRequest request) {
        DataResult<UpdateUserResponse> result = _userService.update(request);
        return GetDataResponseOnlyResultData(_userService.getAll());
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@RequestBody @Valid DeleteUserRequest request) {
        Result result = _userService.delete(request);
        return GetDataResponseOnlyResultData(_userService.getAll());
    }
}