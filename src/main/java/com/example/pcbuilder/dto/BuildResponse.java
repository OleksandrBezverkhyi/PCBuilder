package com.example.pcbuilder.dto;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Об'єкт передачі даних (DTO) для представлення відповіді на запит збірки ПК.
 * Цей клас інкапсулює інформацію про вибрані компоненти, загальну ціну та виявлені проблеми сумісності.
 */
public class BuildResponse {
    /**
     * Мапа, що містить назви вибраних компонентів.
     * Ключ - це тип компонента (наприклад, "CPU", "GPU"), значення - його назва.
     */
    @JsonProperty("components")
    private Map<String, String> components;

    /**
     * Загальна ціна всіх вибраних компонентів.
     */
    @JsonProperty("totalPrice")
    private double totalPrice;

    /**
     * Мапа, що містить виявлені проблеми сумісності.
     * Ключ - це опис пов'язаних компонентів (наприклад, "CPU/Motherboard"), значення - детальний опис проблеми.
     */
    @JsonProperty("compatibilityIssues")
    private Map<String, String> compatibilityIssues;

    /**
     * Конструктор для створення нового об'єкта BuildResponse.
     *
     * @param components          Мапа вибраних компонентів.
     * @param totalPrice          Загальна ціна збірки.
     * @param compatibilityIssues Мапа виявлених проблем сумісності.
     */
    public BuildResponse(Map<String, String> components, double totalPrice, Map<String, String> compatibilityIssues) {
        this.components = components;
        this.totalPrice = totalPrice;
        this.compatibilityIssues = compatibilityIssues;
    }

    /**
     * Повертає мапу вибраних компонентів.
     *
     * @return Мапа компонентів.
     */
    public Map<String, String> getComponents() {
        return components;
    }

    /**
     * Повертає загальну ціну збірки.
     *
     * @return Загальна ціна.
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Повертає мапу проблем сумісності.
     *
     * @return Мапа проблем сумісності.
     */
    public Map<String, String> getCompatibilityIssues() {
        return compatibilityIssues;
    }
}