package com.example.pcbuilder.controller;

import com.example.pcbuilder.dto.BuildRequest;
import com.example.pcbuilder.dto.BuildResponse;
import com.example.pcbuilder.model.*;
import com.example.pcbuilder.service.PcBuilderService;
import com.example.pcbuilder.builder.Computer;
import com.example.pcbuilder.builder.ComputerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/build")
public class BuildController {

    @Autowired
    private PcBuilderService pcBuilderService;    @PostMapping
    public BuildResponse buildPC(@RequestBody BuildRequest request) {
        Map<String, String> selectedComponents = new LinkedHashMap<>();
        Map<String, String> compatibilityIssues = new LinkedHashMap<>();
        double totalPrice = 0;

        try {
            // Validate request
            if (request.MOTHERBOARD == null) throw new IllegalArgumentException("Motherboard ID is required");
            if (request.CPU == null) throw new IllegalArgumentException("CPU ID is required");
            if (request.GPU == null) throw new IllegalArgumentException("GPU ID is required");
            if (request.RAM == null) throw new IllegalArgumentException("RAM ID is required");
            if (request.STORAGE == null) throw new IllegalArgumentException("Storage ID is required");
            if (request.PSU == null) throw new IllegalArgumentException("PSU ID is required");
            if (request.CASE == null) throw new IllegalArgumentException("Case ID is required");

            // Fetching components
            Motherboard motherboard = pcBuilderService.getMotherboardById(request.MOTHERBOARD);
            if (motherboard == null) throw new IllegalArgumentException("Motherboard not found");
            
            CPU cpu = pcBuilderService.getCpuById(request.CPU);
            if (cpu == null) throw new IllegalArgumentException("CPU not found");
            
            GPU gpu = pcBuilderService.getGpuById(request.GPU);
            if (gpu == null) throw new IllegalArgumentException("GPU not found");
            
            RAM ram = pcBuilderService.getRamById(request.RAM);
            if (ram == null) throw new IllegalArgumentException("RAM not found");
            
            Storage storage = pcBuilderService.getStorageById(request.STORAGE);
            if (storage == null) throw new IllegalArgumentException("Storage not found");
            
            PSU psu = pcBuilderService.getPsuById(request.PSU);
            if (psu == null) throw new IllegalArgumentException("PSU not found");
            
            Case pcCase = pcBuilderService.getCaseById(request.CASE);
            if (pcCase == null) throw new IllegalArgumentException("Case not found");

            // Using ComputerBuilder to create a Computer object - set motherboard first
            ComputerBuilder computerBuilder = new ComputerBuilder()
                    .setMotherboard(motherboard)  // Set motherboard first for proper compatibility checks
                    .setCpu(cpu)
                    .setGpu(gpu)
                    .setRam(ram, 1)                .setStorage(storage)
                .setPsu(psu)
                .setCase(pcCase);

            // Check compatibility before building
            if (computerBuilder.getCpu() == null) {
                compatibilityIssues.put("CPU", "CPU is not compatible with the selected motherboard socket");
            }
            if (computerBuilder.getGpu() == null) {
                compatibilityIssues.put("GPU", "GPU is not compatible with the selected motherboard interface");
            }
            if (computerBuilder.getRam() == null) {
                compatibilityIssues.put("RAM", "RAM is not compatible with the selected motherboard");
            }
            if (computerBuilder.getStorage() == null) {
                compatibilityIssues.put("Storage", "Storage is not compatible with the selected motherboard");
            }
            if (computerBuilder.getPcCase() == null) {
                compatibilityIssues.put("Case", "Case form factor is not compatible with the selected motherboard");
            }

            // Only build if there are no compatibility issues
            if (compatibilityIssues.isEmpty()) {
                try {
                    Computer computer = computerBuilder.build();
                    
                    // Add components and calculate total price
                    selectedComponents.put("Motherboard", motherboard.getName());
                    selectedComponents.put("CPU", cpu.getName());
                    selectedComponents.put("GPU", gpu.getName());
                    selectedComponents.put("RAM", ram.getName());
                    selectedComponents.put("Storage", storage.getName());
                    selectedComponents.put("PSU", psu.getName());
                    selectedComponents.put("Case", pcCase.getName());

                    totalPrice = motherboard.getPrice() + 
                               cpu.getPrice() + 
                               gpu.getPrice() + 
                               ram.getPrice() + 
                               storage.getPrice() + 
                               psu.getPrice() + 
                               pcCase.getPrice();
                } catch (IllegalStateException e) {
                    compatibilityIssues.put("General", e.getMessage());
                }
            }

            return new BuildResponse(selectedComponents, totalPrice, compatibilityIssues);
        } catch (IllegalArgumentException e) {
            compatibilityIssues.put("Error", e.getMessage());
            return new BuildResponse(selectedComponents, totalPrice, compatibilityIssues);
        } catch (Exception e) {
            compatibilityIssues.put("Error", "An unexpected error occurred: " + e.getMessage());
            return new BuildResponse(selectedComponents, totalPrice, compatibilityIssues);
        }
    }
}
