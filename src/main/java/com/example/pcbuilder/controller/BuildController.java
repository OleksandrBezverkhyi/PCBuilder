package com.example.pcbuilder.controller;

import com.example.pcbuilder.dto.BuildRequest;
import com.example.pcbuilder.dto.BuildResponse;
import com.example.pcbuilder.model.*;
import com.example.pcbuilder.service.PcBuilderService;
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
        double totalPrice = 0;

        CPU cpu = pcBuilderService.getCpuById(request.CPU);
        GPU gpu = pcBuilderService.getGpuById(request.GPU);
        RAM ram = pcBuilderService.getRamById(request.RAM);
        Storage storage = pcBuilderService.getStorageById(request.STORAGE);
        Motherboard motherboard = pcBuilderService.getMotherboardById(request.MOTHERBOARD);
        PSU psu = pcBuilderService.getPsuById(request.PSU);
        Case pcCase = pcBuilderService.getCaseById(request.CASE);

        if (cpu != null) {
            selectedComponents.put("CPU", cpu.getName());
            totalPrice += cpu.getPrice();
        } else {
            System.out.println("CPU not found.");
        }

        if (gpu != null) {
            selectedComponents.put("GPU", gpu.getName());
            totalPrice += gpu.getPrice();
        } else {
            System.out.println("GPU not found.");
        }

        if (ram != null) {
            selectedComponents.put("RAM", ram.getName());
            totalPrice += ram.getPrice();
        } else {
            System.out.println("RAM not found.");
        }

        if (storage != null) {
            selectedComponents.put("Storage", storage.getName());
            totalPrice += storage.getPrice();
        } else {
            System.out.println("Storage not found.");
        }

        if (motherboard != null) {
            selectedComponents.put("Motherboard", motherboard.getName());
            totalPrice += motherboard.getPrice();
        } else {
            System.out.println("Motherboard not found.");
        }

        if (psu != null) {
            selectedComponents.put("PSU", psu.getName());
            totalPrice += psu.getPrice();
        } else {
            System.out.println("PSU not found.");
        }

        if (pcCase != null) {
            selectedComponents.put("Case", pcCase.getName());
            totalPrice += pcCase.getPrice();
        } else {
            System.out.println("Case not found.");
        }

        System.out.println("Total Price: " + totalPrice);

        return new BuildResponse(selectedComponents, totalPrice);
    }
}
