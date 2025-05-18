package com.example.pcbuilder.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Клас, що представляє материнську плату комп'ютера.
 * Містить інформацію про модель плати та її вартість.
 * Надає методи для отримання характеристик плати.
 */
@Entity
public class Motherboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;



    /**
     * Основной конструктор для створення об'єкта материнської плати.
     *
     * @param name назва моделі материнської плати (наприклад, "ASUS ROG Strix Z790-E")
     * @param price вартість материнської плати у грошових одиницях
     * @throws IllegalArgumentException якщо передана ціна є від'ємною
     */
    public Motherboard(String name, double price) {
        if (price < 0) throw new IllegalArgumentException("Ціна не може бути від'ємною");
        if (name == null) throw new NullPointerException("Ім'я не може бути null");
        if (name.isBlank()) throw new IllegalArgumentException("Ім'я не може бути пустим");
        this.name = name;
        this.price = price;
    }

    public Motherboard() {}

    /**
     * Конструктор копіювання для створення нової материнської плати на основі існуючої.
     *
     * @param other об'єкт материнської плати для копіювання
     * @throws NullPointerException якщо переданий об'єкт є null
     */
    public Motherboard(Motherboard other) {
        if (other == null) throw new NullPointerException("Об'єкт для копіювання не може бути null");
        this.name = other.name;
        this.price = other.price;
        this.id = other.id;
    }

    /**
     * Отримати поточну вартість материнської плати.
     *
     * @return вартість материнської плати типу double
     */
    public double getPrice() {
        return price;
    }

    /**
     * Отримати модель материнської плати.
     *
     * @return назва моделі типу String
     */
    public String getName() {
        return name;
    }

    /**
     * Повертає рядкове представлення об'єкта Motherboard.
     */
    @Override
    public String toString() {
        return "Motherboard{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    /**
     * Порівнює об'єкт Storage з іншим об'єктом на рівність.
     *
     * @param o об'єкт для порівняння
     * @return true якщо об'єкти рівні, false в іншому випадку
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Motherboard that = (Motherboard) o;
        return Double.compare(price, that.price) == 0 && Objects.equals(name, that.name);
    }

    /**
     * Повертає хеш-код об'єкта.
     *
     * @return хеш-код об'єкта
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}