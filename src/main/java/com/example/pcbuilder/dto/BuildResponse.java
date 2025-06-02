package com.example.pcbuilder.dto;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Об'єкт передачі даних (DTO) для передачі результату запиту на збірку ПК клієнту.
 * Цей клас інкапсулює деталі вибраних компонентів, їх загальну вартість
 * та будь-які виявлені проблеми сумісності.
 */
public class BuildResponse {
    /**
     * Карта, що представляє компоненти, які були успішно вибрані для збірки ПК.
     * Ключі – це категорії компонентів (наприклад, "CPU", "GPU"), а значення – їх назви.
     * Ця властивість буде серіалізована як "components" у вихідному JSON.
     */
    @JsonProperty("components")
    private Map<String, String> components;

    /**
     * Розрахована загальна вартість усіх вибраних та сумісних компонентів.
     * Ця властивість буде серіалізована як "totalPrice" у вихідному JSON.
     */
    @JsonProperty("totalPrice")
    private double totalPrice;

    /**
     * Карта, що деталізує будь-які проблеми сумісності, виявлені під час процесу збірки ПК.
     * Ключі вказують на компоненти, залучені до проблеми (наприклад, "CPU/Motherboard"),
     * а значення надають опис несумісності.
     * Ця властивість буде серіалізована як "compatibilityIssues" у вихідному JSON.
     */
    @JsonProperty("compatibilityIssues")
    private Map<String, String> compatibilityIssues;

    /**
     * Конструює новий BuildResponse.
     *
     * @param components Карта успішно вибраних компонентів (категорія до назви).
     * @param totalPrice Загальна розрахована вартість збірки.
     * @param compatibilityIssues Карта будь-яких виявлених проблем сумісності.
     */
    public BuildResponse(Map<String, String> components, double totalPrice, Map<String, String> compatibilityIssues) {
        this.components = components;
        this.totalPrice = totalPrice;
        this.compatibilityIssues = compatibilityIssues;
    }

    /**
     * Отримує карту вибраних компонентів.
     *
     * @return {@link Map}, де ключі – це категорії компонентів, а значення – назви компонентів.
     */
    public Map<String, String> getComponents() {
        return components;
    }

    /**
     * Отримує загальну вартість збірки ПК.
     *
     * @return Загальна вартість як double.
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Отримує карту проблем сумісності.
     *
     * @return {@link Map}, де ключі описують компоненти, залучені до проблеми, а значення надають деталі несумісності.
     */
    public Map<String, String> getCompatibilityIssues() {
        return compatibilityIssues;
    }
}