package com.example.todoapi.service;

import com.example.todoapi.model.Task;
import com.example.todoapi.repository.TaskRepository;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;


@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        taskRepository.save(task);
        return task;
    }

    public List<Task> listAll() {
        Sort sort = Sort.by(Sort.Direction.ASC, "priority");
        return taskRepository.findAll(sort);
    }

    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    public Task updateTask(Long id, Task task) {
        Task taskToUpdate = taskRepository.findById(id).get();
        if (taskToUpdate == null) {
            return null;
        }
        else {
            taskToUpdate.setName(task.getName());
            taskToUpdate.setDescription(task.getDescription());
            taskToUpdate.setDone(task.isDone());
            taskToUpdate.setPriority(task.getPriority());
            taskToUpdate.setUpdateDate(task.getUpdateDate());
            taskRepository.save(taskToUpdate);
            return taskToUpdate;
        }
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task searchID(Long id) {
        return taskRepository.findById(id).get();
    }
}
