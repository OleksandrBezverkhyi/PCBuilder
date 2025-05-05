package com.example.pcbuilder.model;

import jakarta.persistence.*;

@Entity
public class CPU {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private String socket;

    public CPU() {}

    public CPU(String name, double price, String socket) {
        this.name = name;
        this.price = price;
        this.socket = socket;
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
}
