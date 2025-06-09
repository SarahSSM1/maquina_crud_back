package com.vmmanager.virtualmachinemanagerbackend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class TaskLog {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String usuario; 
    private LocalDateTime dataHora;
    private String nomeMaquinaVirtual;
    private String acao; 

    @PrePersist
    protected void onCreate() {
        this.dataHora = LocalDateTime.now();
    }
}