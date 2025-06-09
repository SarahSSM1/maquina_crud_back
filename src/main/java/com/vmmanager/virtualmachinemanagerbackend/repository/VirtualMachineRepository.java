package com.vmmanager.virtualmachinemanagerbackend.repository;

import com.vmmanager.virtualmachinemanagerbackend.model.VirtualMachine;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface VirtualMachineRepository extends JpaRepository<VirtualMachine, UUID> {
}