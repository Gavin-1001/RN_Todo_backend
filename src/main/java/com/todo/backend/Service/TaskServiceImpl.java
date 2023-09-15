package com.todo.backend.Service;

import com.todo.backend.Entity.Task;
import com.todo.backend.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task addTaskTest(Task task) {
        task.setDate_created(new Date());
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long id, Task task) {
        Task updateTask = taskRepository.findById(id).get();


        //Task title
        if (Objects.nonNull(task.getTitle()) && !"".equalsIgnoreCase(task.getTitle())) {
            updateTask.setTitle(task.getTitle());
        }

        //text
        if (Objects.nonNull(task.getText()) && !"".equalsIgnoreCase(task.getText())) {
            updateTask.setText(task.getText());
        }

        //getReminder
        if (Objects.nonNull(task.getReminder()) && !"".equalsIgnoreCase(String.valueOf(task.getReminder()))) {
            updateTask.setReminder(task.getReminder());
        }

        //Date_created
        if (Objects.nonNull(task.getDate_created()) && !"".equalsIgnoreCase(String.valueOf(task.getDate_created()))) {
            updateTask.setDate_created(task.getDate_created());
        }


        //Date_completed
        if (Objects.nonNull(task.getDate_completed()) && !"".equalsIgnoreCase(String.valueOf(task.getDate_completed()))) {
            updateTask.setDate_completed(task.getDate_completed());
        }


        return taskRepository.save(updateTask);
    }

    @Override
    public void deleteEmployee(Long id) {
        taskRepository.deleteTaskById(id);
    }

    @Override
    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }
}
