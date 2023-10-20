package com.example.ToDoListProject.business.concretes;

import com.example.ToDoListProject.business.abstracts.ReminderService;
import com.example.ToDoListProject.business.requests.reminder.CreateReminderRequest;
import com.example.ToDoListProject.business.requests.reminder.DeleteReminderRequest;
import com.example.ToDoListProject.business.requests.reminder.UpdateReminderRequest;
import com.example.ToDoListProject.business.responses.reminder.CreateReminderResponse;
import com.example.ToDoListProject.business.responses.reminder.DeleteReminderResponse;
import com.example.ToDoListProject.business.responses.reminder.GetAllReminderResponse;
import com.example.ToDoListProject.business.responses.reminder.UpdateReminderResponse;
import com.example.ToDoListProject.core.mapping.ModelMapperService;
import com.example.ToDoListProject.core.results.DataResult;
import com.example.ToDoListProject.core.results.SuccessDataResult;
import com.example.ToDoListProject.dataAccess.abstracts.ReminderRepository;
import com.example.ToDoListProject.entities.Reminder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReminderManager implements ReminderService {
    private final ReminderRepository _reminderRepository;
    private final ModelMapperService _modelMapperService;

    @Override
    public DataResult<List<GetAllReminderResponse>> getAll() {
        List<Reminder> reminders = _reminderRepository.findAll();
        List<GetAllReminderResponse> responses = reminders.stream().map(reminder -> _modelMapperService
                .forResponse().map(reminder, GetAllReminderResponse.class)).toList();
        return new SuccessDataResult<List<GetAllReminderResponse>>(responses, "Success");
    }

    @Override
    public DataResult<CreateReminderResponse> add(CreateReminderRequest request) {
        Reminder reminder = _modelMapperService.forResponse().map(request, Reminder.class);
        _reminderRepository.save(reminder);
        CreateReminderResponse response = _modelMapperService.forResponse().map(reminder, CreateReminderResponse.class);
        return new SuccessDataResult<CreateReminderResponse>(response, "Success");
    }

    @Override
    public DataResult<UpdateReminderResponse> update(UpdateReminderRequest request) {
        Reminder reminder = _modelMapperService.forResponse().map(request, Reminder.class);
        _reminderRepository.save(reminder);
        UpdateReminderResponse response = _modelMapperService.forResponse().map(reminder, UpdateReminderResponse.class);
        return new SuccessDataResult<UpdateReminderResponse>(response, "Success");
    }

    @Override
    public DataResult<DeleteReminderResponse> delete(DeleteReminderRequest request) {
        Reminder reminder = _modelMapperService.forRequest().map(request, Reminder.class);
        _reminderRepository.delete(reminder);
        DeleteReminderResponse response = _modelMapperService.forResponse().map(reminder, DeleteReminderResponse.class);
        return new SuccessDataResult<DeleteReminderResponse>(response, "Success");
    }
}