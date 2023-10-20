package com.example.ToDoListProject.webApi.controllers;

import com.example.ToDoListProject.core.results.DataResult;
import com.example.ToDoListProject.core.results.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    public ResponseEntity<?> GetDataResponseOnlyResultData(DataResult dataResult) {
        return dataResult.isSuccess() ? ResponseEntity.ok(dataResult) : ResponseEntity.badRequest().body(dataResult);
    }


    public ResponseEntity<?> GetDataResponseOnlyResult(Result result) {
        return result.isSuccess() ? ResponseEntity.ok(result) : ResponseEntity.badRequest().body(result);
    }
}