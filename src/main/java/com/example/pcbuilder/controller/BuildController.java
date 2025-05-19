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
    private PcBuilderService pcBuilderService;

    @PostMapping
    public BuildResponse buildPC(@RequestBody BuildRequest request) {
        Map<String, String> selectedComponents = new LinkedHashMap<>();
        Map<String, String> compatibilityIssues = new LinkedHashMap<>();
        double totalPrice = 0;

        // Fetching components
        CPU cpu = pcBuilderService.getCpuById(request.CPU);
        GPU gpu = pcBuilderService.getGpuById(request.GPU);
        RAM ram = pcBuilderService.getRamById(request.RAM);
        Storage storage = pcBuilderService.getStorageById(request.STORAGE);
        Motherboard motherboard = pcBuilderService.getMotherboardById(request.MOTHERBOARD);
        PSU psu = pcBuilderService.getPsuById(request.PSU);
        Case pcCase = pcBuilderService.getCaseById(request.CASE);

        // Using ComputerBuilder to create a Computer object
        ComputerBuilder computerBuilder = new ComputerBuilder()
                .setCpu(cpu)
                .setGpu(gpu)
                .setRam(ram)
                .setStorage(storage)
                .setMotherboard(motherboard)
                .setPsu(psu)
                .setCase(pcCase);

        Computer computer = computerBuilder.build();

        // Calculating total price and checking compatibility
        if (cpu != null) {
            selectedComponents.put("CPU", cpu.getName());
            totalPrice += cpu.getPrice();
        }

        if (gpu != null) {
            selectedComponents.put("GPU", gpu.getName());
            totalPrice += gpu.getPrice();
        }

        if (ram != null) {
            selectedComponents.put("RAM", ram.getName());
            totalPrice += ram.getPrice();
        }

        if (storage != null) {
            selectedComponents.put("Storage", storage.getName());
            totalPrice += storage.getPrice();
        }

        if (motherboard != null) {
            selectedComponents.put("Motherboard", motherboard.getName());
            totalPrice += motherboard.getPrice();
        }

        if (psu != null) {
            selectedComponents.put("PSU", psu.getName());
            totalPrice += psu.getPrice();
        }

        if (pcCase != null) {
            selectedComponents.put("Case", pcCase.getName());
            totalPrice += pcCase.getPrice();
        }

        System.out.println("Total Price: " + totalPrice);

        return new BuildResponse(selectedComponents, totalPrice, compatibilityIssues);
    }
}
