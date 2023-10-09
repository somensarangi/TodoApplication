package com.fundamentals.TodoApp.controller;

import com.fundamentals.TodoApp.entity.Task;
import com.fundamentals.TodoApp.error.TaskNotFoundException;
import com.fundamentals.TodoApp.service.TaskService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    private final Logger LOGGER = LoggerFactory.getLogger(TaskController.class);

    @PostMapping("/saveTask")
    public Task saveTask(@Valid @RequestBody Task task){
        LOGGER.info("Inside saveDepartment of TaskController");
        return taskService.saveTask(task);
    }

    @GetMapping("/getTask")
    public List<Task> fetchTasks(){
        LOGGER.info("Inside getTask of TaskController");
        return taskService.fetchTasks();
    }

    @GetMapping("/getTask/name/{name}")
    public Task fetchTaskByName(@PathVariable("name") String taskName){
        return taskService.fetchTaskByName(taskName);
    }
    @GetMapping("/getTask/{id}")
    public Task fetchTaskById(@PathVariable("id") Long taskId) throws TaskNotFoundException {
        return taskService.fetchTaskById(taskId);
    }

    @DeleteMapping("/deleteTasks/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long taskId){
        taskService.deleteTask(taskId);
        return "Department deleted successfully!";
    }

    @PutMapping("/updateTask/{id}")
    public Task updateDepartment(@PathVariable("id") Long taskId, @RequestBody Task task){
        return taskService.updateTask(taskId, task);
    }

}
