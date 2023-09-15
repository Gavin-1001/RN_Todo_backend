package com.todo.backend.Controller;

import com.todo.backend.Entity.Task;
import com.todo.backend.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo/")
@CrossOrigin
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("add")
    public ResponseEntity<?> addEmployee(@RequestBody Task task){
        return ResponseEntity.ok(taskService.addTaskTest(task));
        //http://localhost:8080/api/employees
    }

    @PutMapping("updateTask/{id}")
    public ResponseEntity<?> update(@RequestBody Task task, @PathVariable Long id) {
        Task updatedStudent = taskService.updateTask(id, task);
        if (updatedStudent == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedStudent);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        taskService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
        //http://localhost:8080/api/employees/6
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Task>> findAllTasks() {
        return ResponseEntity.ok(taskService.findAllTasks());
        //http://localhost:8080/api/employees
    }



}