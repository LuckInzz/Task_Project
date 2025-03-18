package com.example.todoapi.controller;

import com.example.todoapi.model.Task;
import com.example.todoapi.service.TaskService;

import jakarta.persistence.Id;

//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping
    public List<Task> listAll() {
        return taskService.listAll();
    }

    @PutMapping("/{id}")
    public void updateTask(@PathVariable Long id, @RequestBody Task task) {
        taskService.updateTask(id, task);
    }

    @GetMapping("/{id}")
    public Task searchID(@PathVariable Long id) {
        return taskService.searchID(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }


}