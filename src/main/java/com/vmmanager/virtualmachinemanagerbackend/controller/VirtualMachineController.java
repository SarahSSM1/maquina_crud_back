package com.vmmanager.virtualmachinemanagerbackend.controller;

import com.vmmanager.virtualmachinemanagerbackend.model.VirtualMachine;
import com.vmmanager.virtualmachinemanagerbackend.service.VirtualMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/virtual-machines")
@CrossOrigin(origins = "*") 
public class VirtualMachineController {

    @Autowired
    private VirtualMachineService vmService;

    @GetMapping
    public List<VirtualMachine> getAllVirtualMachines() {
        return vmService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VirtualMachine> getVirtualMachineById(@PathVariable UUID id) {
        return vmService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<VirtualMachine> createVirtualMachine(@RequestBody VirtualMachine vm) {
        if (vm.getCpu() <= 0 || vm.getMemoria() <= 0 || vm.getDisco() <= 0 || vm.getNome() == null || vm.getNome().trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        VirtualMachine newVm = vmService.save(vm);
        return new ResponseEntity<>(newVm, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VirtualMachine> updateVirtualMachine(@PathVariable UUID id, @RequestBody VirtualMachine vmDetails) {
        if (vmDetails.getCpu() <= 0 || vmDetails.getMemoria() <= 0 || vmDetails.getDisco() <= 0 || vmDetails.getNome() == null || vmDetails.getNome().trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        try {
            VirtualMachine updatedVm = vmService.update(id, vmDetails);
            return ResponseEntity.ok(updatedVm);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVirtualMachine(@PathVariable UUID id) {
        try {
            vmService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<VirtualMachine> updateVirtualMachineStatus(@PathVariable UUID id, @RequestParam VirtualMachine.VmStatus status) {
        try {
            VirtualMachine updatedVm = vmService.updateStatus(id, status);
            return ResponseEntity.ok(updatedVm);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}