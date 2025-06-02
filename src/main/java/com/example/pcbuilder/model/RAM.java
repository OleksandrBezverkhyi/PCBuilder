package com.example.pcbuilder.model;

import jakarta.persistence.*;

/**
 * Представляє компонент оперативної пам'яті (RAM) у застосунку "PC Builder".
 * Ця сутність відображається на таблицю "RAM" у базі даних.
 */
@Entity
public class RAM {
    /**
     * Унікальний ідентифікатор для модуля оперативної пам'яті.
     * Цей ідентифікатор генерується автоматично базою даних.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Назва модуля оперативної пам'яті (наприклад, "Corsair Vengeance LPX 16GB DDR4 3200MHz").
     */
    private String name;

    /**
     * Ціна модуля оперативної пам'яті.
     */
    private double price;

    /**
     * Конструктор за замовчуванням, необхідний для JPA.
     */
    public RAM() {}

    /**
     * Створює новий екземпляр RAM з вказаною назвою та ціною.
     *
     * @param name Назва модуля оперативної пам'яті.
     * @param price Ціна модуля оперативної пам'яті.
     */
    public RAM(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Повертає ідентифікатор модуля оперативної пам'яті.
     *
     * @return Ідентифікатор модуля оперативної пам'яті.
     */
    public Long getId() {
        return id;
    }

    /**
     * Повертає назву модуля оперативної пам'яті.
     *
     * @return Назва модуля оперативної пам'яті.
     */
    public String getName() {
        return name;
    }

    /**
     * Повертає ціну модуля оперативної пам'яті.
     *
     * @return Ціна модуля оперативної пам'яті.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Встановлює ідентифікатор модуля оперативної пам'яті.
     *
     * @param id Новий ідентифікатор для модуля оперативної пам'яті.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Встановлює назву модуля оперативної пам'яті.
     *
     * @param name Нова назва для модуля оперативної пам'яті.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Встановлює ціну модуля оперативної пам'яті.
     *
     * @param price Нова ціна для модуля оперативної пам'яті.
     */
    public void setPrice(double price) {
        this.price = price;
    }
}