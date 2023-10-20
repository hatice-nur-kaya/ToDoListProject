package com.example.ToDoListProject.business.concretes;

import com.example.ToDoListProject.business.abstracts.CategoryService;
import com.example.ToDoListProject.business.requests.categories.CreateCategoryRequest;
import com.example.ToDoListProject.business.requests.categories.DeleteCategoryRequest;
import com.example.ToDoListProject.business.requests.categories.UpdateCategoryRequest;
import com.example.ToDoListProject.business.responses.categories.*;
import com.example.ToDoListProject.core.mapping.ModelMapperService;
import com.example.ToDoListProject.core.results.DataResult;
import com.example.ToDoListProject.core.results.SuccessDataResult;
import com.example.ToDoListProject.dataAccess.abstracts.CategoryRepository;
import com.example.ToDoListProject.entities.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    private final CategoryRepository _categoryRepository;
    private final ModelMapperService _modelMapperService;

    @Override
    public DataResult<List<GetAllCategoryResponse>> getAll() {
        List<Category> categories = _categoryRepository.findAll();
        List<GetAllCategoryResponse> responses = categories.stream().map(parent -> _modelMapperService
                .forResponse().map(parent, GetAllCategoryResponse.class)).toList();
        return new SuccessDataResult<List<GetAllCategoryResponse>>(responses, "Success");
    }

    @Override
    public DataResult<GetByIdCategoryResponse> getById(int id) {
        Category category = _categoryRepository.findById(id).get();
        GetByIdCategoryResponse response = _modelMapperService.forResponse().map(category, GetByIdCategoryResponse.class);
        return new SuccessDataResult<GetByIdCategoryResponse>(response, "Success");
    }

    @Override
    public DataResult<CreateCategoryResponse> add(CreateCategoryRequest request) {
        Category category = _modelMapperService.forRequest().map(request, Category.class);
        _categoryRepository.save(category);
        CreateCategoryResponse response = _modelMapperService.forResponse().map(category, CreateCategoryResponse.class);
        return new SuccessDataResult<CreateCategoryResponse>(response, "Success");
    }

    @Override
    public DataResult<UpdateCategoryResponse> update(UpdateCategoryRequest request) {
        Category category = _modelMapperService.forRequest().map(request, Category.class);
        _categoryRepository.save(category);
        UpdateCategoryResponse response = _modelMapperService.forResponse().map(category, UpdateCategoryResponse.class);
        return new SuccessDataResult<UpdateCategoryResponse>(response, "Success");
    }

    @Override
    public DataResult<DeleteCategoryResponse> delete(DeleteCategoryRequest request) {
        Category category = _modelMapperService.forRequest().map(request, Category.class);
        _categoryRepository.delete(category);
        DeleteCategoryResponse response = _modelMapperService.forResponse().map(category, DeleteCategoryResponse.class);
        return new SuccessDataResult<DeleteCategoryResponse>(response, "Success");
    }

    @Override
    public DataResult<List<GetAllCategoryResponse>> getAllSearch(String keyword) {
        List<Category> categories = _categoryRepository.findByName(keyword);
        List<GetAllCategoryResponse> responses = categories.stream().map(category -> _modelMapperService
                .forResponse().map(category, GetAllCategoryResponse.class)).toList();
        return new SuccessDataResult<List<GetAllCategoryResponse>>(responses, "Success");
    }
}