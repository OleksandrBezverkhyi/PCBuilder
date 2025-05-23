package com.example.pcbuilder.builder;

import com.example.pcbuilder.model.*;

public class Computer {
    private final CPU cpu;
    private final GPU gpu;
    private final RAM ram;
    private final Storage storage;
    private final Motherboard motherboard;
    private final PSU psu;
    private final Case pcCase;

    public Computer(CPU cpu, GPU gpu, RAM ram, Storage storage, Motherboard motherboard, PSU psu, Case pcCase) {
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.storage = storage;
        this.motherboard = motherboard;
        this.psu = psu;
        this.pcCase = pcCase;
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

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public PSU getPsu() {
        return psu;
    }

    public Case getPcCase() {
        return pcCase;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu=" + cpu +
                ", gpu=" + gpu +
                ", ram=" + ram +
                ", storage=" + storage +
                ", motherboard=" + motherboard +
                ", psu=" + psu +
                ", pcCase=" + pcCase +
                '}';
    }
}


