package com.example.pcbuilder.dto;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BuildResponse {
    @JsonProperty("components")
    private Map<String, String> components;

    @JsonProperty("totalPrice")
    private double totalPrice;

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