package com.example.pcbuilder.dto;

import java.util.Map;

public class BuildResponse {
    public Map<String, String> components;
    public double totalPrice;

    public BuildResponse(Map<String, String> components, double totalPrice) {
        this.components = components;
        this.totalPrice = totalPrice;
    }

    public Map<String, String> getComponents() {
        return components;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
