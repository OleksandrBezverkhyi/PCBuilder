package com.example.pcbuilder.model;

import com.example.pcbuilder.model.enums.RAMInterface;
import jakarta.persistence.*;

import java.util.Objects;

/**
 * Клас, що представляє модуль оперативної пам'яті (RAM) комп'ютера.
 * Зберігає інформацію про назву модуля та його вартість.
 * Надає методи для роботи з об'єктами пам'яті, включаючи порівняння та копіювання.
 */
@Entity
public class RAM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    @Enumerated(EnumType.STRING)
    private RAMInterface compInterface;

    /**
     * Основний конструктор для створення об'єкта оперативної пам'яті.
     *
     * @param name           назва моделі RAM (не може бути null або пустою)
     * @param price          вартість RAM (має бути не менше 0)
     * @param compInterface  інтерфейс RAM (не може бути null)
     * @throws IllegalArgumentException якщо ціна від'ємна або назва пуста
     * @throws NullPointerException     якщо назва або інтерфейс є null
     */
    public RAM(String name, double price, String compInterface) {
        if (price < 0) throw new IllegalArgumentException("Ціна не може бути від'ємною");
        if (name == null) throw new NullPointerException("Ім'я не може бути null");
        if (name.isBlank()) throw new IllegalArgumentException("Ім'я не може бути пустим");
        if (compInterface == null) throw new NullPointerException("Інтерфейс не може бути null");
        this.price = price;
        this.name = name;
        this.compInterface = RAMInterface.fromValue(compInterface);
    }

    public RAM() {

    }

    /**
     * Конструктор копіювання для створення нового об'єкта на основі існуючого.
     *
     * @param other об'єкт RAM для копіювання
     * @throws NullPointerException якщо переданий об'єкт є null
     */
    public RAM(RAM other) {
        if (other == null) throw new NullPointerException("Об'єкт для копіювання не може бути null");
        this.name = other.name;
        this.price = other.price;
        this.id = other.id;
    }

    /**
     * Повертає вартість модуля пам'яті.
     *
     * @return вартість модуля пам'яті
     */
    public double getPrice() {
        return price;
    }

    public RAMInterface getCompInterface() {
        return compInterface;
    }

    /**
     * Повертає назву модуля пам'яті.
     *
     * @return назва модуля пам'яті
     */
    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Повертає рядкове представлення об'єкта RAM.
     */
    @Override
    public String toString() {
        return "RAM{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    /**
     * Порівнює об'єкт RAM з іншим об'єктом на рівність.
     *
     * @param o об'єкт для порівняння
     * @return true якщо об'єкти рівні, false в іншому випадку
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RAM ram = (RAM) o;
        return Double.compare(price, ram.price) == 0 && Objects.equals(name, ram.name);
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