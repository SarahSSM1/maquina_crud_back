package com.vmmanager.virtualmachinemanagerbackend.service;

import com.vmmanager.virtualmachinemanagerbackend.model.TaskLog;
import com.vmmanager.virtualmachinemanagerbackend.repository.TaskLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskLogService {

    @Autowired
    private TaskLogRepository taskLogRepository;

    public List<TaskLog> findAll() {
        return taskLogRepository.findAll();
    }
}