package com.example.pcbuilder.model;

import jakarta.persistence.*;

@Entity
public class GPU {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private int lengthMm;
    private int minPsuWattage;

    public GPU() {}

    public GPU(String name, double price, int lengthMm, int minPsuWattage) {
        this.name = name;
        this.price = price;
        this.lengthMm = lengthMm;
        this.minPsuWattage = minPsuWattage;
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

    public int getLengthMm() {
        return lengthMm;
    }

    public int getMinPsuWattage() {
        return minPsuWattage;
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

    public void setLengthMm(int lengthMm) {
        this.lengthMm = lengthMm;
    }

    public void setMinPsuWattage(int minPsuWattage) {
        this.minPsuWattage = minPsuWattage;
    }
}
