package com.example.ToDoListProject.webApi.controllers;

import com.example.ToDoListProject.business.abstracts.ReminderService;
import com.example.ToDoListProject.business.requests.reminder.CreateReminderRequest;
import com.example.ToDoListProject.business.requests.reminder.DeleteReminderRequest;
import com.example.ToDoListProject.business.requests.reminder.UpdateReminderRequest;
import com.example.ToDoListProject.business.responses.reminder.CreateReminderResponse;
import com.example.ToDoListProject.business.responses.reminder.UpdateReminderResponse;
import com.example.ToDoListProject.core.results.DataResult;
import com.example.ToDoListProject.core.results.Result;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reminders")
@AllArgsConstructor
public class ReminderController extends BaseController {
    private final ReminderService _reminderService;

    @GetMapping("getall")
    public ResponseEntity<?> getAll() {
        return GetDataResponseOnlyResultData((_reminderService).getAll());
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody CreateReminderRequest request) {
        DataResult<CreateReminderResponse> result = _reminderService.add(request);
        return GetDataResponseOnlyResultData(result);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid UpdateReminderRequest request) {
        DataResult<UpdateReminderResponse> result = _reminderService.update(request);
        return GetDataResponseOnlyResultData(result);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@RequestBody @Valid DeleteReminderRequest request) {
        Result result = _reminderService.delete(request);
        return GetDataResponseOnlyResult(result);
    }
}