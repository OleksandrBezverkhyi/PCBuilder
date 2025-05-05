package com.example.pcbuilder.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pc_case")
public class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private int maxGpuLengthMm;

    public Case() {}

    public Case(String name, double price, int maxGpuLengthMm) {
        this.name = name;
        this.price = price;
        this.maxGpuLengthMm = maxGpuLengthMm;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getMaxGpuLengthMm() {
        return maxGpuLengthMm;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setMaxGpuLengthMm(int maxGpuLengthMm) {
        this.maxGpuLengthMm = maxGpuLengthMm;
    }
}
