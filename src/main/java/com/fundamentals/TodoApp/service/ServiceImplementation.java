package com.fundamentals.TodoApp.service;

import com.fundamentals.TodoApp.entity.Task;
import com.fundamentals.TodoApp.error.TaskNotFoundException;
import com.fundamentals.TodoApp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ServiceImplementation implements TaskService{

    @Autowired
    private TaskRepository taskRepository;


    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public List<Task> fetchTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task updateTask(Long taskId, Task task) {
        Task taskDataBase = taskRepository.findById(taskId).get();

        if(Objects.nonNull(task.getTaskName())
                &&!"".equalsIgnoreCase(task.getTaskName())){
            taskDataBase.setTaskName(task.getTaskName());
        }

        if(Objects.nonNull(task.getTaskStatus())
                &&!"".equalsIgnoreCase(task.getTaskStatus())){
            taskDataBase.setTaskStatus(task.getTaskStatus());
        }

        if(Objects.nonNull(task.getTaskDescription())
                &&!"".equalsIgnoreCase(task.getTaskDescription())){
            taskDataBase.setTaskDescription(task.getTaskDescription());
        }

        return taskRepository.save(taskDataBase);
    }

    @Override
    public Task fetchTaskByName(String taskName) {
        return taskRepository.findByTaskNameIgnoreCase(taskName);
    }

    @Override
    public Task fetchTaskById(Long taskId) throws TaskNotFoundException {
        Optional<Task> task =
                taskRepository.findById(taskId);

        if(!task.isPresent()) {
            throw new TaskNotFoundException("Department Not Available");
        }

        return  task.get();
    }
}
