package com.example.pcbuilder.model;

import jakarta.persistence.*;

/**
 * Представляє компонент блоку живлення (PSU) у застосунку "PC Builder".
 * Ця сутність відображається на таблицю "PSU" у базі даних.
 */
@Entity
public class PSU {
    /**
     * Унікальний ідентифікатор для блоку живлення.
     * Цей ідентифікатор генерується автоматично базою даних.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Назва блоку живлення.
     */
    private String name;

    /**
     * Ціна блоку живлення.
     */
    private double price;

    /**
     * Максимальна вихідна потужність блоку живлення у ватах.
     * Важливо для перевірки сумісності з відеокартою та іншими компонентами.
     */
    private int wattage;

    /**
     * Конструктор за замовчуванням, необхідний для JPA.
     */
    public PSU() {}

    /**
     * Створює новий екземпляр PSU з вказаною назвою, ціною та потужністю.
     *
     * @param name Назва блоку живлення.
     * @param price Ціна блоку живлення.
     * @param wattage Максимальна вихідна потужність блоку живлення у ватах.
     */
    public PSU(String name, double price, int wattage) {
        this.name = name;
        this.price = price;
        this.wattage = wattage;
    }

    /**
     * Повертає ідентифікатор блоку живлення.
     *
     * @return Ідентифікатор блоку живлення.
     */
    public Long getId() {
        return id;
    }

    /**
     * Повертає назву блоку живлення.
     *
     * @return Назва блоку живлення.
     */
    public String getName() {
        return name;
    }

    /**
     * Повертає ціну блоку живлення.
     *
     * @return Ціна блоку живлення.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Повертає максимальну вихідну потужність блоку живлення у ватах.
     *
     * @return Потужність блоку живлення у ватах.
     */
    public int getWattage() {
        return wattage;
    }

    /**
     * Встановлює ідентифікатор блоку живлення.
     *
     * @param id Новий ідентифікатор для блоку живлення.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Встановлює назву блоку живлення.
     *
     * @param name Нова назва для блоку живлення.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Встановлює ціну блоку живлення.
     *
     * @param price Нова ціна для блоку живлення.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Встановлює максимальну вихідну потужність блоку живлення у ватах.
     *
     * @param wattage Нова потужність блоку живлення у ватах.
     */
    public void setWattage(int wattage) {
        this.wattage = wattage;
    }
}