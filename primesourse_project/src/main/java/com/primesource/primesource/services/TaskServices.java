package com.primesource.primesource.services;

import com.primesource.primesource.entities.Tasks;

import java.util.List;

public interface TaskServices {

    Tasks addTask(Tasks task);
    List<Tasks> getAllTasks();
    Tasks getTaskById(Long id);
    Tasks updateTask(Tasks task);
    void deleteTask(Tasks task);

    int updateTaskDone(Long taskId);

}
