package com.vmmanager.virtualmachinemanagerbackend.controller;

import com.vmmanager.virtualmachinemanagerbackend.model.TaskLog;
import com.vmmanager.virtualmachinemanagerbackend.service.TaskLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/task-logs")
@CrossOrigin(origins = "*") 
public class TaskLogController {

    @Autowired
    private TaskLogService taskLogService;

    @GetMapping
    public List<TaskLog> getAllTaskLogs() {
        return taskLogService.findAll();
    }
}