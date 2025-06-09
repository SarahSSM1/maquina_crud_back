package com.vmmanager.virtualmachinemanagerbackend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class VirtualMachine {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private int cpu;
    private int memoria; 
    private int disco;   
    private LocalDateTime dataDeCriacao;

    @Enumerated(EnumType.STRING)
    private VmStatus status;

    public enum VmStatus {
        START, STOP, SUSPEND
    }

    @PrePersist
    protected void onCreate() {
        this.dataDeCriacao = LocalDateTime.now();
        if (this.status == null) {
            this.status = VmStatus.STOP; 
        }
    }
}