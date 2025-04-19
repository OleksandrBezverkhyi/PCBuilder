/*package com.example.pcbuilder.controller;

import com.example.pcbuilder.model.*;
import com.example.pcbuilder.repository.*;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/build")
@CrossOrigin(origins = "*")
public class PcBuildController {

    private final CPURepository cpuRepository;
    private final MotherboardRepository motherboardRepository;
    private final RAMRepository ramRepository;
    private final StorageRepository storageRepository;
    private final GPURepository gpuRepository;
    private final PSURepository psuRepository;
    private final CaseRepository pcCaseRepository;

    public PcBuildController(CPURepository cpuRepository, MotherboardRepository motherboardRepository,
                             RAMRepository ramRepository, StorageRepository storageRepository,
                             GPURepository gpuRepository, PSURepository psuRepository,
                             CaseRepository pcCaseRepository) {
        this.cpuRepository = cpuRepository;
        this.motherboardRepository = motherboardRepository;
        this.ramRepository = ramRepository;
        this.storageRepository = storageRepository;
        this.gpuRepository = gpuRepository;
        this.psuRepository = psuRepository;
        this.pcCaseRepository = pcCaseRepository;
    }

    @PostMapping
    public Map<String, Object> buildPc(@RequestBody Map<String, Long> selectedIds) {
        CPU cpu = cpuRepository.findById(selectedIds.get("cpu")).orElseThrow();
        Motherboard mb = motherboardRepository.findById(selectedIds.get("motherboard")).orElseThrow();
        RAM ram = ramRepository.findById(selectedIds.get("ram")).orElseThrow();
        Storage storage = storageRepository.findById(selectedIds.get("storage")).orElseThrow();
        GPU gpu = gpuRepository.findById(selectedIds.get("gpu")).orElseThrow();
        PSU psu = psuRepository.findById(selectedIds.get("psu")).orElseThrow();
        Case pcCase = pcCaseRepository.findById(selectedIds.get("pcCase")).orElseThrow();

        double totalPrice = cpu.getPrice() + mb.getPrice() + ram.getPrice() + storage.getPrice() + gpu.getPrice() +
                psu.getPrice() + pcCase.getPrice();


        Map<String, Object> result = new HashMap<>();
        result.put("cpu", cpu);
        result.put("motherboard", mb);
        result.put("ram", ram);
        result.put("storage", storage);
        result.put("gpu", gpu);
        result.put("psu", psu);
        result.put("case", pcCase);
        result.put("totalPrice", totalPrice);

        return result;
    }
}*/