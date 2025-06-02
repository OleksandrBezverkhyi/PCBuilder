package com.example.pcbuilder.model;

import jakarta.persistence.*;

/**
 * Представляє компонент пристрою зберігання даних (наприклад, SSD, HDD) у застосунку "PC Builder".
 * Ця сутність відображається на таблицю "Storage" у базі даних.
 */
@Entity
public class Storage {
    /**
     * Унікальний ідентифікатор для пристрою зберігання даних.
     * Цей ідентифікатор генерується автоматично базою даних.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Назва пристрою зберігання даних (наприклад, "Samsung 970 EVO Plus 1TB NVMe SSD", "Seagate Barracuda 2TB HDD").
     */
    private String name;

    /**
     * Ціна пристрою зберігання даних.
     */
    private double price;

    /**
     * Конструктор за замовчуванням, необхідний для JPA.
     */
    public Storage() {}

    /**
     * Створює новий екземпляр Storage з вказаною назвою та ціною.
     *
     * @param name Назва пристрою зберігання даних.
     * @param price Ціна пристрою зберігання даних.
     */
    public Storage(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Повертає ідентифікатор пристрою зберігання даних.
     *
     * @return Ідентифікатор пристрою зберігання даних.
     */
    public Long getId() {
        return id;
    }

    /**
     * Повертає назву пристрою зберігання даних.
     *
     * @return Назва пристрою зберігання даних.
     */
    public String getName() {
        return name;
    }

    /**
     * Повертає ціну пристрою зберігання даних.
     *
     * @return Ціна пристрою зберігання даних.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Встановлює ідентифікатор пристрою зберігання даних.
     *
     * @param id Новий ідентифікатор для пристрою зберігання даних.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Встановлює назву пристрою зберігання даних.
     *
     * @param name Нова назва для пристрою зберігання даних.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Встановлює ціну пристрою зберігання даних.
     *
     * @param price Нова ціна для пристрою зберігання даних.
     */
    public void setPrice(double price) {
        this.price = price;
    }
}