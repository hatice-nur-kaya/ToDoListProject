package com.example.ToDoListProject.business.concretes;

import com.example.ToDoListProject.business.abstracts.TaskService;
import com.example.ToDoListProject.business.requests.tasks.*;
import com.example.ToDoListProject.business.responses.tasks.*;
import com.example.ToDoListProject.core.mapping.ModelMapperService;
import com.example.ToDoListProject.core.results.DataResult;
import com.example.ToDoListProject.core.results.SuccessDataResult;
import com.example.ToDoListProject.dataAccess.abstracts.TaskRepository;
import com.example.ToDoListProject.entities.Task;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskManager implements TaskService {
    private final TaskRepository _taskRepository;
    private final ModelMapperService _modelMapperService;

    @Override
    public DataResult<List<GetAllTaskResponse>> getAll() {
        List<Task> tasks = _taskRepository.findAll();
        List<GetAllTaskResponse> responses = tasks.stream().map(task -> _modelMapperService
                .forResponse().map(task, GetAllTaskResponse.class)).toList();
        return new SuccessDataResult<List<GetAllTaskResponse>>(responses, "Success");
    }

    @Override
    public DataResult<GetByIdTaskResponse> getById(int id) {
        Task task = _taskRepository.findById(id).get();
        GetByIdTaskResponse response = _modelMapperService.forResponse().map(task, GetByIdTaskResponse.class);
        return new SuccessDataResult<GetByIdTaskResponse>(response, "Success");
    }

    @Override
    public DataResult<CreateTaskResponse> add(CreateTaskRequest request) {
        Task task = _modelMapperService.forRequest().map(request, Task.class);
        _taskRepository.save(task);
        CreateTaskResponse response = _modelMapperService.forResponse().map(task, CreateTaskResponse.class);
        return new SuccessDataResult<CreateTaskResponse>(response, "Success");
    }

    @Override
    public DataResult<UpdateTaskResponse> update(UpdateTaskRequest request) {
        Task task = _modelMapperService.forRequest().map(request, Task.class);
        _taskRepository.save(task);
        UpdateTaskResponse response = _modelMapperService.forResponse().map(task, UpdateTaskResponse.class);
        return new SuccessDataResult<UpdateTaskResponse>(response, "Success");
    }

    @Override
    public DataResult<DeleteTaskResponse> delete(DeleteTaskRequest request) {
        Task task = _modelMapperService.forRequest().map(request, Task.class);
        _taskRepository.delete(task);
        DeleteTaskResponse response = _modelMapperService.forResponse().map(task, DeleteTaskResponse.class);
        return new SuccessDataResult<DeleteTaskResponse>(response, "Success");
    }

    @Override
    public DataResult<List<GetAllTaskResponse>> getAllSorted(CreatePageRequest createPageRequest) {
        Sort sort = Sort.by(Sort.Direction.fromString(createPageRequest.getSortDirection()),createPageRequest.getSortBy());
        Pageable pageable = PageRequest.of(createPageRequest.getPageNumber(), createPageRequest.getPageSize(),sort);
        Page<Task> tasks = _taskRepository.findAll(pageable);
        List<GetAllTaskResponse> responses = tasks.stream().map(task -> _modelMapperService
                .forResponse().map(task, GetAllTaskResponse.class)).toList();
        return new SuccessDataResult<List<GetAllTaskResponse>>(responses, "Success");
    }

    @Override
    public DataResult<List<GetAllTaskResponse>> getAllSearch(String keyword) {
        List<Task> tasks = _taskRepository.findByTitleContainingOrStatementContaining(keyword,keyword);
        List<GetAllTaskResponse> responses = tasks.stream().map(task -> _modelMapperService
                .forResponse().map(task, GetAllTaskResponse.class)).toList();
        return new SuccessDataResult<List<GetAllTaskResponse>>(responses, "Success");
    }
}