package com.vmmanager.virtualmachinemanagerbackend.service;

import com.vmmanager.virtualmachinemanagerbackend.model.TaskLog;
import com.vmmanager.virtualmachinemanagerbackend.model.VirtualMachine;
import com.vmmanager.virtualmachinemanagerbackend.repository.TaskLogRepository;
import com.vmmanager.virtualmachinemanagerbackend.repository.VirtualMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VirtualMachineService {

    @Autowired
    private VirtualMachineRepository vmRepository;

    @Autowired
    private TaskLogRepository taskLogRepository;

    public List<VirtualMachine> findAll() {
        return vmRepository.findAll();
    }

    public Optional<VirtualMachine> findById(UUID id) {
        return vmRepository.findById(id);
    }

    public VirtualMachine save(VirtualMachine vm) {
        VirtualMachine savedVm = vmRepository.save(vm);
        logTask("System", "Criação", savedVm.getNome());
        return savedVm;
    }

    public VirtualMachine update(UUID id, VirtualMachine vmDetails) {
        return vmRepository.findById(id).map(vm -> {
            vm.setNome(vmDetails.getNome());
            vm.setCpu(vmDetails.getCpu());
            vm.setMemoria(vmDetails.getMemoria());
            vm.setDisco(vmDetails.getDisco());
            vm.setStatus(vmDetails.getStatus()); 
            VirtualMachine updatedVm = vmRepository.save(vm);
            logTask("System", "Edição", updatedVm.getNome());
            return updatedVm;
        }).orElseThrow(() -> new RuntimeException("Máquina virtual não encontrada com id " + id));
    }

    public void deleteById(UUID id) {
        Optional<VirtualMachine> vm = vmRepository.findById(id);
        if (vm.isPresent()) {
            vmRepository.deleteById(id);
            logTask("System", "Exclusão", vm.get().getNome());
        } else {
            throw new RuntimeException("Máquina virtual não encontrada com id " + id);
        }
    }

    public VirtualMachine updateStatus(UUID id, VirtualMachine.VmStatus newStatus) {
        return vmRepository.findById(id).map(vm -> {
            String oldStatus = vm.getStatus().name();
            vm.setStatus(newStatus);
            VirtualMachine updatedVm = vmRepository.save(vm);
            logTask("System", "Status Update: " + oldStatus + " -> " + newStatus.name(), updatedVm.getNome());
            return updatedVm;
        }).orElseThrow(() -> new RuntimeException("Máquina virtual não encontrada com id " + id));
    }

    private void logTask(String usuario, String acao, String nomeMaquinaVirtual) {
        TaskLog log = new TaskLog();
        log.setUsuario(usuario);
        log.setAcao(acao);
        log.setNomeMaquinaVirtual(nomeMaquinaVirtual);
        taskLogRepository.save(log);
    }
}