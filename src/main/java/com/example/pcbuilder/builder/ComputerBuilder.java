package com.example.pcbuilder.builder;

import com.example.pcbuilder.model.*;

public class ComputerBuilder {
    private CPU cpu;
    private GPU gpu;
    private RAM ram;
    private Storage storage;
    private Motherboard motherboard;
    private PSU psu;
    private Case pcCase;

    public ComputerBuilder setCpu(CPU cpu) {
        this.cpu = cpu;
        return this;
    }

    public ComputerBuilder setGpu(GPU gpu) {
        this.gpu = gpu;
        return this;
    }

    public ComputerBuilder setRam(RAM ram) {
        this.ram = ram;
        return this;
    }

    public ComputerBuilder setStorage(Storage storage) {
        this.storage = storage;
        return this;
    }

    public ComputerBuilder setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
        return this;
    }

    public ComputerBuilder setPsu(PSU psu) {
        this.psu = psu;
        return this;
    }

    public ComputerBuilder setCase(Case pcCase) {
        this.pcCase = pcCase;
        return this;
    }

    public Computer build() {
        return new Computer(cpu, gpu, ram, storage, motherboard, psu, pcCase);
    }
}

