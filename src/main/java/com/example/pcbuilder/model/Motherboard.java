package com.example.pcbuilder.model;

import jakarta.persistence.*;

@Entity
public class Motherboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private String socket;
    private int maxRamSizeGb;

    public Motherboard() {}

    public Motherboard(String name, double price, String socket, int maxRamSizeGb) {
        this.name = name;
        this.price = price;
        this.socket = socket;
        this.maxRamSizeGb = maxRamSizeGb;
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

    public String getSocket() {
        return socket;
    }

    public int getMaxRamSizeGb() {
        return maxRamSizeGb;
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

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public void setMaxRamSizeGb(int maxRamSizeGb) {
        this.maxRamSizeGb = maxRamSizeGb;
    }
}
