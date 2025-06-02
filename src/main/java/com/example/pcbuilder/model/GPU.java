package com.example.pcbuilder.model;

import jakarta.persistence.*;

/**
 * Представляє компонент графічного процесора (GPU) у застосунку "PC Builder".
 * Ця сутність відображається на таблицю "GPU" у базі даних.
 */
@Entity
public class GPU {
    /**
     * Унікальний ідентифікатор для відеокарти.
     * Цей ідентифікатор генерується автоматично базою даних.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Назва відеокарти.
     */
    private String name;

    /**
     * Ціна відеокарти.
     */
    private double price;

    /**
     * Довжина відеокарти в міліметрах.
     * Важливо для перевірки сумісності з корпусом ПК.
     */
    private int lengthMm;

    /**
     * Мінімальна рекомендована потужність блоку живлення (PSU) у ватах,
     * необхідна для цієї відеокарти.
     * Важливо для перевірки сумісності з блоком живлення.
     */
    private int minPsuWattage;

    /**
     * Конструктор за замовчуванням, необхідний для JPA.
     */
    public GPU() {}

    /**
     * Створює новий екземпляр GPU з вказаною назвою, ціною, довжиною та мінімальною потужністю БЖ.
     *
     * @param name Назва відеокарти.
     * @param price Ціна відеокарти.
     * @param lengthMm Довжина відеокарти в міліметрах.
     * @param minPsuWattage Мінімальна рекомендована потужність БЖ у ватах.
     */
    public GPU(String name, double price, int lengthMm, int minPsuWattage) {
        this.name = name;
        this.price = price;
        this.lengthMm = lengthMm;
        this.minPsuWattage = minPsuWattage;
    }

    /**
     * Повертає ідентифікатор відеокарти.
     *
     * @return Ідентифікатор відеокарти.
     */
    public Long getId() {
        return id;
    }

    /**
     * Повертає назву відеокарти.
     *
     * @return Назва відеокарти.
     */
    public String getName() {
        return name;
    }

    /**
     * Повертає ціну відеокарти.
     *
     * @return Ціна відеокарти.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Повертає довжину відеокарти в міліметрах.
     *
     * @return Довжина відеокарти в міліметрах.
     */
    public int getLengthMm() {
        return lengthMm;
    }

    /**
     * Повертає мінімальну рекомендовану потужність БЖ для цієї відеокарти у ватах.
     *
     * @return Мінімальна потужність БЖ у ватах.
     */
    public int getMinPsuWattage() {
        return minPsuWattage;
    }

    /**
     * Встановлює ідентифікатор відеокарти.
     *
     * @param id Новий ідентифікатор для відеокарти.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Встановлює назву відеокарти.
     *
     * @param name Нова назва для відеокарти.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Встановлює ціну відеокарти.
     *
     * @param price Нова ціна для відеокарти.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Встановлює довжину відеокарти в міліметрах.
     *
     * @param lengthMm Нова довжина відеокарти в міліметрах.
     */
    public void setLengthMm(int lengthMm) {
        this.lengthMm = lengthMm;
    }

    /**
     * Встановлює мінімальну рекомендовану потужність БЖ для цієї відеокарти у ватах.
     *
     * @param minPsuWattage Нова мінімальна потужність БЖ у ватах.
     */
    public void setMinPsuWattage(int minPsuWattage) {
        this.minPsuWattage = minPsuWattage;
    }
}