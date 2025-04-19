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
    private PcBuilderService pcBuilderService; // інжекція сервісу

    @PostMapping
    public BuildResponse buildPC(@RequestBody BuildRequest request) {
        System.out.println("Received build request:");
        System.out.println("CPU ID: " + request.CPU);
        System.out.println("GPU ID: " + request.GPU);
        System.out.println("RAM ID: " + request.RAM);
        System.out.println("Storage ID: " + request.STORAGE);
        System.out.println("Motherboard ID: " + request.MOTHERBOARD);
        System.out.println("PSU ID: " + request.PSU);
        System.out.println("Case ID: " + request.CASE);

        Map<String, String> selectedComponents = new LinkedHashMap<>();
        double totalPrice = 0;

        // Замість безпосереднього звернення до репозиторіїв, викликаємо методи сервісу
        CPU cpu = pcBuilderService.getCpuById(request.CPU);
        GPU gpu = pcBuilderService.getGpuById(request.GPU);
        RAM ram = pcBuilderService.getRamById(request.RAM);
        Storage storage = pcBuilderService.getStorageById(request.STORAGE);
        Motherboard motherboard = pcBuilderService.getMotherboardById(request.MOTHERBOARD);
        PSU psu = pcBuilderService.getPsuById(request.PSU);
        Case pcCase = pcBuilderService.getCaseById(request.CASE);

        // Додаємо компоненти до результату
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

        // Повертаємо відповідь
        return new BuildResponse(selectedComponents, totalPrice);
    }
}
