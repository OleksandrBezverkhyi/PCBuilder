package com.example.pcbuilder.model;

import jakarta.persistence.*;

/**
 * Представляє компонент материнської плати у застосунку "PC Builder".
 * Ця сутність відображається на таблицю "Motherboard" у базі даних.
 */
@Entity
public class Motherboard {
    /**
     * Унікальний ідентифікатор для материнської плати.
     * Цей ідентифікатор генерується автоматично базою даних.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Назва материнської плати.
     */
    private String name;

    /**
     * Ціна материнської плати.
     */
    private double price;

    /**
     * Тип сокета процесора, який підтримує материнська плата (наприклад, "LGA1700", "AM5").
     * Важливо для перевірки сумісності з процесором.
     */
    private String socket;

    /**
     * Максимальний обсяг оперативної пам'яті (RAM) у гігабайтах, який може підтримувати ця материнська плата.
     */
    private int maxRamSizeGb;

    /**
     * Конструктор за замовчуванням, необхідний для JPA.
     */
    public Motherboard() {}

    /**
     * Створює новий екземпляр материнської плати з вказаною назвою, ціною, сокетом та максимальним обсягом RAM.
     *
     * @param name Назва материнської плати.
     * @param price Ціна материнської плати.
     * @param socket Тип сокета процесора материнської плати.
     * @param maxRamSizeGb Максимальний обсяг RAM (у ГБ), який підтримує материнська плата.
     */
    public Motherboard(String name, double price, String socket, int maxRamSizeGb) {
        this.name = name;
        this.price = price;
        this.socket = socket;
        this.maxRamSizeGb = maxRamSizeGb;
    }

    /**
     * Повертає ідентифікатор материнської плати.
     *
     * @return Ідентифікатор материнської плати.
     */
    public Long getId() {
        return id;
    }

    /**
     * Повертає назву материнської плати.
     *
     * @return Назва материнської плати.
     */
    public String getName() {
        return name;
    }

    /**
     * Повертає ціну материнської плати.
     *
     * @return Ціна материнської плати.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Повертає тип сокета процесора материнської плати.
     *
     * @return Тип сокета.
     */
    public String getSocket() {
        return socket;
    }

    /**
     * Повертає максимальний обсяг RAM (у ГБ), який підтримує материнська плата.
     *
     * @return Максимальний обсяг RAM у гігабайтах.
     */
    public int getMaxRamSizeGb() {
        return maxRamSizeGb;
    }

    /**
     * Встановлює ідентифікатор материнської плати.
     *
     * @param id Новий ідентифікатор для материнської плати.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Встановлює назву материнської плати.
     *
     * @param name Нова назва для материнської плати.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Встановлює ціну материнської плати.
     *
     * @param price Нова ціна для материнської плати.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Встановлює тип сокета процесора материнської плати.
     *
     * @param socket Новий тип сокета для материнської плати.
     */
    public void setSocket(String socket) {
        this.socket = socket;
    }

    /**
     * Встановлює максимальний обсяг RAM (у ГБ), який підтримує материнська плата.
     *
     * @param maxRamSizeGb Новий максимальний обсяг RAM у гігабайтах.
     */
    public void setMaxRamSizeGb(int maxRamSizeGb) {
        this.maxRamSizeGb = maxRamSizeGb;
    }
}