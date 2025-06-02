package com.example.pcbuilder.model;

import jakarta.persistence.*;

/**
 * Представляє компонент корпусу ПК у застосунку "PC Builder".
 * Ця сутність відображається на таблицю "pc_case" у базі даних.
 */
@Entity
@Table(name = "pc_case")
public class Case {
    /**
     * Унікальний ідентифікатор корпусу ПК.
     * Цей ідентифікатор генерується автоматично базою даних.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Назва корпусу ПК.
     */
    private String name;

    /**
     * Ціна корпусу ПК.
     */
    private double price;

    /**
     * Максимальна довжина відеокарти (Graphics Processing Unit), яка може поміститися в цей корпус, у міліметрах.
     */
    private int maxGpuLengthMm;

    /**
     * Конструктор за замовчуванням, необхідний для JPA.
     */
    public Case() {}

    /**
     * Створює новий екземпляр корпусу з вказаною назвою, ціною та максимальною довжиною GPU.
     *
     * @param name Назва корпусу ПК.
     * @param price Ціна корпусу ПК.
     * @param maxGpuLengthMm Максимальна довжина GPU (у мм), яку підтримує корпус.
     */
    public Case(String name, double price, int maxGpuLengthMm) {
        this.name = name;
        this.price = price;
        this.maxGpuLengthMm = maxGpuLengthMm;
    }

    /**
     * Повертає ідентифікатор корпусу ПК.
     *
     * @return Ідентифікатор корпусу ПК.
     */
    public Long getId() {
        return id;
    }

    /**
     * Повертає назву корпусу ПК.
     *
     * @return Назва корпусу ПК.
     */
    public String getName() {
        return name;
    }

    /**
     * Повертає ціну корпусу ПК.
     *
     * @return Ціна корпусу ПК.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Повертає максимальну довжину GPU (у мм), яку підтримує корпус ПК.
     *
     * @return Максимальна довжина GPU в міліметрах.
     */
    public int getMaxGpuLengthMm() {
        return maxGpuLengthMm;
    }

    /**
     * Встановлює ідентифікатор корпусу ПК.
     *
     * @param id Новий ідентифікатор для корпусу ПК.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Встановлює назву корпусу ПК.
     *
     * @param name Нова назва для корпусу ПК.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Встановлює ціну корпусу ПК.
     *
     * @param price Нова ціна для корпусу ПК.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Встановлює максимальну довжину GPU (у мм), яку підтримує корпус ПК.
     *
     * @param maxGpuLengthMm Нова максимальна довжина GPU в міліметрах.
     */
    public void setMaxGpuLengthMm(int maxGpuLengthMm) {
        this.maxGpuLengthMm = maxGpuLengthMm;
    }
}