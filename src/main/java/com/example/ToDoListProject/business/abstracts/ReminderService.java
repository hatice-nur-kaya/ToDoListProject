package com.example.ToDoListProject.business.abstracts;

import com.example.ToDoListProject.business.requests.reminder.CreateReminderRequest;
import com.example.ToDoListProject.business.requests.reminder.DeleteReminderRequest;
import com.example.ToDoListProject.business.requests.reminder.UpdateReminderRequest;
import com.example.ToDoListProject.business.responses.reminder.CreateReminderResponse;
import com.example.ToDoListProject.business.responses.reminder.DeleteReminderResponse;
import com.example.ToDoListProject.business.responses.reminder.GetAllReminderResponse;
import com.example.ToDoListProject.business.responses.reminder.UpdateReminderResponse;
import com.example.ToDoListProject.core.results.DataResult;

import java.util.List;

public interface ReminderService {
    DataResult<List<GetAllReminderResponse>> getAll();

    DataResult<CreateReminderResponse> add(CreateReminderRequest request);

    DataResult<UpdateReminderResponse> update(UpdateReminderRequest request);

    DataResult<DeleteReminderResponse> delete(DeleteReminderRequest request);
}