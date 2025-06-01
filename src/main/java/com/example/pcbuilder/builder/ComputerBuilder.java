package com.example.pcbuilder.builder;

import com.example.pcbuilder.model.*;

import java.util.Objects;

public class ComputerBuilder {
    private CPU cpu;
    private GPU gpu;
    private RAM ram;
    private Storage storage;
    private Motherboard motherboard;
    private PSU psu;
    private Case pcCase;
    int ramCount;

    public ComputerBuilder setCpu(CPU cpu) {
        Objects.requireNonNull(cpu);
        if (motherboard == null || cpu.getCompInterface() == motherboard.getCpuSocket()) {
            this.cpu = cpu;
        } else {
            this.cpu = null;
        }
        return this;
    }

    public ComputerBuilder setGpu(GPU gpu) {
        Objects.requireNonNull(gpu);
        if (motherboard == null || motherboard.getGpuInterface().isCompatibleWith(gpu.getCompInterface())) {
            this.gpu = gpu;
        } else {
            this.gpu = null;
        }
        return this;
    }

    public ComputerBuilder setRam(RAM ram, int count) {
        Objects.requireNonNull(ram);
        if (count <= 0) throw new IllegalArgumentException();
        if (motherboard == null || ram.getCompInterface() == motherboard.getRamInterface()) {
            this.ram = ram;
            ramCount = count;
        } else {
            this.ram = null;
        }
        return this;
    }

    public ComputerBuilder setStorage(Storage storage) {
        Objects.requireNonNull(storage);
        if (motherboard == null || storage.getCompInterface() == motherboard.getStorageInterface()) {
            this.storage = storage;
        } else {
            this.storage = null;
        }
        return this;
    }

    public ComputerBuilder setPsu(PSU psu) {
        Objects.requireNonNull(psu);
        this.psu = psu;

        return this;
    }

    public ComputerBuilder setCase(Case pcCase) {
        Objects.requireNonNull(pcCase);
        if (motherboard == null || pcCase.getCompInterface().fits(motherboard.getCaseFormFactor())) {
            this.pcCase = pcCase;
        } else {
            this.pcCase = null;
        }
        return this;
    }

    public ComputerBuilder setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
        // Повторно перевіряємо вже додані компоненти
        if (cpu != null) setCpu(null);
        if (gpu != null) setGpu(null);
        if (ram != null) setRam(null, 1);
        if (storage != null) setStorage(null);
        if (psu != null) setPsu(null);
        if (pcCase != null) setCase(null);
        return this;
    }

    public Computer build() {
        if (cpu == null) throw new IllegalStateException("CPU не встановлено");
        if (gpu == null) throw new IllegalStateException("GPU не встановлено");
        if (ram == null) throw new IllegalStateException("RAM не встановлено");
        if (storage == null) throw new IllegalStateException("Storage не встановлено");
        if (motherboard == null) throw new IllegalStateException("Motherboard не встановлено");
        if (psu == null) throw new IllegalStateException("PSU не встановлено");
        if (pcCase == null) throw new IllegalStateException("Case не встановлено");

        return new Computer(cpu, gpu, ram, storage, motherboard, psu, pcCase);
    }

    public CPU getCpu() {
        return cpu;
    }

    public GPU getGpu() {
        return gpu;
    }

    public RAM getRam() {
        return ram;
    }

    public Storage getStorage() {
        return storage;
    }

    public Case getPcCase() {
        return pcCase;
    }

    public PSU getPsu() {
        return psu;
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }
}

