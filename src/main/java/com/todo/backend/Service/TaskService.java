package com.todo.backend.Service;

import com.todo.backend.Entity.Task;

import java.util.List;

public interface TaskService {
    Task addTaskTest(Task task);

    Task updateTask(Long id, Task task);

    void deleteEmployee(Long id);

    List<Task> findAllTasks();

}
