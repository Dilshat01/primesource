package com.primesource.primesource.services.Impl;

import com.primesource.primesource.entities.Tasks;
import com.primesource.primesource.repositories.TaskRepository;
import com.primesource.primesource.services.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskServices {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Tasks> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Tasks addTask(Tasks task) {
        return taskRepository.save(task);
    }

    @Override
    public Tasks getTaskById(Long id) {
        return taskRepository.findById(id).get();
    }

    @Override
    public Tasks updateTask(Tasks task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Tasks task) {
        taskRepository.delete(task);
    }

    @Override
    public int updateTaskDone(Long taskId) {
        return taskRepository.setDone(taskId);
    }
}
