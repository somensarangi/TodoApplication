package com.fundamentals.TodoApp.service;

import com.fundamentals.TodoApp.entity.Task;
import com.fundamentals.TodoApp.error.TaskNotFoundException;

import java.util.List;

public interface TaskService {

    public Task saveTask(Task task);

    public void deleteTask(Long taskId);

    public List<Task> fetchTasks();

    public Task updateTask(Long taskId, Task task);

    public Task fetchTaskByName(String taskName);

    public Task fetchTaskById(Long taskId) throws TaskNotFoundException;

}
