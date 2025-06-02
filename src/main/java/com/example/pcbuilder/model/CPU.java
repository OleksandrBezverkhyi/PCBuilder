package com.example.pcbuilder.model;

import jakarta.persistence.*;

/**
 * Представляє компонент центрального процесора (CPU) у застосунку "PC Builder".
 * Ця сутність відображається на таблицю "CPU" у базі даних.
 */
@Entity
public class CPU {
    /**
     * Унікальний ідентифікатор для процесора.
     * Цей ідентифікатор генерується автоматично базою даних.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Назва процесора.
     */
    private String name;

    /**
     * Ціна процесора.
     */
    private double price;

    /**
     * Тип сокета процесора (наприклад, "LGA1700", "AM5").
     * Важливо для перевірки сумісності з материнською платою.
     */
    private String socket;

    /**
     * Конструктор за замовчуванням, необхідний для JPA.
     */
    public CPU() {}

    /**
     * Створює новий екземпляр CPU з вказаною назвою, ціною та типом сокета.
     *
     * @param name Назва процесора.
     * @param price Ціна процесора.
     * @param socket Тип сокета процесора.
     */
    public CPU(String name, double price, String socket) {
        this.name = name;
        this.price = price;
        this.socket = socket;
    }

    /**
     * Повертає ідентифікатор процесора.
     *
     * @return Ідентифікатор процесора.
     */
    public Long getId() {
        return id;
    }

    /**
     * Повертає назву процесора.
     *
     * @return Назва процесора.
     */
    public String getName() {
        return name;
    }

    /**
     * Повертає ціну процесора.
     *
     * @return Ціна процесора.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Повертає тип сокета процесора.
     *
     * @return Тип сокета.
     */
    public String getSocket() {
        return socket;
    }

    /**
     * Встановлює ідентифікатор процесора.
     *
     * @param id Новий ідентифікатор для процесора.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Встановлює назву процесора.
     *
     * @param name Нова назва для процесора.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Встановлює ціну процесора.
     *
     * @param price Нова ціна для процесора.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Встановлює тип сокета процесора.
     *
     * @param socket Новий тип сокета для процесора.
     */
    public void setSocket(String socket) {
        this.socket = socket;
    }
}