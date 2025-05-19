package com.example.pcbuilder.service;

import com.example.pcbuilder.model.*;
import com.example.pcbuilder.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PcBuilderService {

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

    public CPU getCpuById(Long id) {
        Optional<CPU> cpuOptional = cpuRepository.findById(id);
        return cpuOptional.orElse(null);
    }

    public GPU getGpuById(Long id) {
        Optional<GPU> gpuOptional = gpuRepository.findById(id);
        return gpuOptional.orElse(null);
    }

    public RAM getRamById(Long id) {
        Optional<RAM> ramOptional = ramRepository.findById(id);
        return ramOptional.orElse(null);
    }

    public Storage getStorageById(Long id) {
        Optional<Storage> storageOptional = storageRepository.findById(id);
        return storageOptional.orElse(null);
    }

    public Motherboard getMotherboardById(Long id) {
        Optional<Motherboard> motherboardOptional = motherboardRepository.findById(id);
        return motherboardOptional.orElse(null);
    }

    public PSU getPsuById(Long id) {
        Optional<PSU> psuOptional = psuRepository.findById(id);
        return psuOptional.orElse(null);
    }

    public Case getCaseById(Long id) {
        Optional<Case> caseOptional = pcCaseRepository.findById(id);
        return caseOptional.orElse(null);
    }
}