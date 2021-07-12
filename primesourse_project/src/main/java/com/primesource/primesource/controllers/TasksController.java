package com.primesource.primesource.controllers;


import com.primesource.primesource.entities.Tasks;
import com.primesource.primesource.services.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TasksController {

    @Autowired
    private  TaskServices taskService;

    @GetMapping(value = "/alltasks")
    public ResponseEntity<?> getAllTasks(){
        List<Tasks> allTasks = taskService.getAllTasks();
        return new ResponseEntity<>(allTasks, HttpStatus.OK);
    }

    @PostMapping(value = "/addtask")
    public ResponseEntity<?> addItem(@RequestBody Tasks task){
        taskService.addTask(task);
        return ResponseEntity.ok(task);
    }
    @PutMapping(value = "/updatetask")
    public ResponseEntity<?> saveCard(@RequestBody Tasks task){
        Tasks testTask = taskService.getTaskById(task.getId());
        if(testTask!=null){
            taskService.updateTask(task);
            return ResponseEntity.ok(task);
        }
        taskService.updateTask(task);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
    }

    @PutMapping(value = "/settaskdone")
    public ResponseEntity<?> saveCardTaskDone(@RequestBody Tasks task){
        Tasks testTask = taskService.getTaskById(task.getId());
        if(testTask!=null){
            taskService.updateTaskDone(task.getId());
            return ResponseEntity.ok(task);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
    }

    @DeleteMapping(value = "/deletetask")
    public ResponseEntity<?> deleteItem(@RequestBody Tasks task){
        Tasks testTask = taskService.getTaskById(task.getId());
        if(testTask!=null){
            taskService.deleteTask(testTask);
            return ResponseEntity.ok(testTask);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
    }

}
