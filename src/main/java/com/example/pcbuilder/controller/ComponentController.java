package com.example.pcbuilder.controller;

import com.example.pcbuilder.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/components")
public class ComponentController {

    @Autowired
    private CPURepository cpuRepository;

    @Autowired
    private GPURepository gpuRepository;

    @Autowired
    private RAMRepository ramRepository;

    @Autowired
    private StorageRepository storageRepository;

    @Autowired
    private MotherboardRepository motherboardRepository;

    @Autowired
    private PSURepository psuRepository;

    @Autowired
    private CaseRepository pcCaseRepository;

    @GetMapping("/{type}")
    public List<?> getComponentsByType(@PathVariable String type) {
        System.out.println("Fetching components for type: " + type);

        List<?> components = switch (type.toLowerCase()) {
            case "cpu" -> cpuRepository.findAll();
            case "gpu" -> gpuRepository.findAll();
            case "ram" -> ramRepository.findAll();
            case "storage" -> storageRepository.findAll();
            case "motherboard" -> motherboardRepository.findAll();
            case "psu" -> psuRepository.findAll();
            case "pc_case" -> pcCaseRepository.findAll();
            default -> throw new IllegalArgumentException("Unknown component type: " + type);
        };

        return components;
    }
}