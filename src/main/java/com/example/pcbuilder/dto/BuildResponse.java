package com.example.pcbuilder.dto;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BuildResponse {
    @JsonProperty("components")
    private Map<String, String> components;

    @JsonProperty("totalPrice")
    private double totalPrice;

    @JsonProperty("compatibilityIssues")
    private Map<String, String> compatibilityIssues;

    public BuildResponse(Map<String, String> components, double totalPrice, Map<String, String> compatibilityIssues) {
        this.components = components;
        this.totalPrice = totalPrice;
        this.compatibilityIssues = compatibilityIssues;
    }

    public Map<String, String> getComponents() {
        return components;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Map<String, String> getCompatibilityIssues() {
        return compatibilityIssues;
    }
}
