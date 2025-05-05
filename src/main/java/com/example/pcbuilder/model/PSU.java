package com.example.pcbuilder.model;

import jakarta.persistence.*;

@Entity
public class PSU {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private int wattage;

    public PSU() {}

    public PSU(String name, double price, int wattage) {
        this.name = name;
        this.price = price;
        this.wattage = wattage;
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

    public int getWattage() {
        return wattage;
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

    public void setWattage(int wattage) {
        this.wattage = wattage;
    }
}
