package com.fundamentals.TodoApp.repository;

import com.fundamentals.TodoApp.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    public Task findByTaskNameIgnoreCase(String taskName);

}
