package com.example.pcbuilder.model;

import com.example.pcbuilder.model.enums.StorageInterface;
import jakarta.persistence.*;

import java.util.Objects;

/**
 * Клас, що представляє пристрій зберігання даних (Storage).
 * Зберігає інформацію про назву пристрою та його вартість.
 * Надає методи для роботи з об'єктами типу Storage, включаючи копіювання,
 * порівняння та отримання інформації.
 */
@Entity
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private StorageInterface compInterface;

    /**
     * Основний конструктор для створення об'єкта Storage.
     *
     * @param name назва пристрою зберігання (не може бути null або порожнім)
     * @param price вартість пристрою (не може бути від'ємною)
     * @throws IllegalArgumentException якщо ціна від'ємна або назва порожня
     * @throws NullPointerException якщо назва є null
     */
    public Storage(String name, double price) {
        if (price < 0) throw new IllegalArgumentException("Ціна не може бути від'ємною");
        if (name == null) throw new NullPointerException("Ім'я не може бути null");
        if (name.isBlank()) throw new IllegalArgumentException("Ім'я не може бути пустим");
        this.name = name;
        this.price = price;
    }

    public Storage() {}

    /**
     * Конструктор копіювання для створення нового об'єкта на основі існуючого.
     *
     * @param other об'єкт для копіювання (не може бути null)
     * @throws NullPointerException якщо переданий об'єкт є null
     */
    public Storage(Storage other) {
        if (other == null) throw new NullPointerException("Об'єкт для копіювання не може бути null");
        this.name = other.name;
        this.price = other.price;
        this.id = other.id;
    }

    /**
     * Повертає вартість пристрою зберігання.
     *
     * @return вартість пристрою типу double
     */
    public double getPrice() {
        return price;
    }

    /**
     * Повертає назву пристрою зберігання.
     *
     * @return назва пристрою типу String
     */
    public String getName() {
        return name;
    }

    /**
     * Повертає рядкове представлення об'єкта Storage.
     */
    @Override
    public String toString() {
        return "Storage{" +
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
        Storage storage = (Storage) o;
        return Double.compare(price, storage.price) == 0 && Objects.equals(name, storage.name);
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