package com.vmmanager.virtualmachinemanagerbackend.repository;

import com.vmmanager.virtualmachinemanagerbackend.model.TaskLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface TaskLogRepository extends JpaRepository<TaskLog, UUID> {
}