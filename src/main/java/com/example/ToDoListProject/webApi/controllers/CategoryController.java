package com.example.ToDoListProject.webApi.controllers;

import com.example.ToDoListProject.business.abstracts.CategoryService;
import com.example.ToDoListProject.business.requests.categories.CreateCategoryRequest;
import com.example.ToDoListProject.business.requests.categories.DeleteCategoryRequest;
import com.example.ToDoListProject.business.requests.categories.UpdateCategoryRequest;
import com.example.ToDoListProject.business.responses.categories.CreateCategoryResponse;
import com.example.ToDoListProject.business.responses.categories.GetByIdCategoryResponse;
import com.example.ToDoListProject.business.responses.categories.UpdateCategoryResponse;
import com.example.ToDoListProject.core.results.DataResult;
import com.example.ToDoListProject.core.results.Result;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/catogories")
@AllArgsConstructor
public class CategoryController extends BaseController {
    private final CategoryService _categoryService;

    @GetMapping("getall")
    public ResponseEntity<?> getAll() {
        return GetDataResponseOnlyResultData(_categoryService.getAll());
    }

    @GetMapping("getbyid/{id}")
    public DataResult<GetByIdCategoryResponse> getById(@PathVariable int id) {
        return _categoryService.getById(id);
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody CreateCategoryRequest request) {
        DataResult<CreateCategoryResponse> result = _categoryService.add(request);
        return GetDataResponseOnlyResultData(_categoryService.getAll());
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid UpdateCategoryRequest request) {
        DataResult<UpdateCategoryResponse> result = _categoryService.update(request);
        return GetDataResponseOnlyResultData(_categoryService.getAll());
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@RequestBody @Valid DeleteCategoryRequest request) {
        Result result = _categoryService.delete(request);
        return GetDataResponseOnlyResultData(_categoryService.getAll());
    }
}