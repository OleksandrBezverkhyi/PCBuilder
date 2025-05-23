package com.example.pcbuilder.model;

import com.example.pcbuilder.model.enums.CPUSocket;
import jakarta.persistence.*;

import java.util.Objects;

/**
 * Клас, що представляє центральний процесор (CPU) комп'ютера.
 * Містить інформацію про назву процесора та його ціну.
 */
@Entity
public class CPU {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    @Enumerated(EnumType.STRING)
    private CPUSocket compInterface;

    /**
     * Основний конструктор для створення об'єкта процесора.
     *
     * @param name           назва моделі процесора (не може бути null або пустою)
     * @param price          вартість процесора (має бути не менше 0)
     * @param compInterface  сокет процесора (не може бути null)
     * @throws IllegalArgumentException якщо ціна від'ємна або назва пуста
     * @throws NullPointerException     якщо назва або інтерфейс є null
     */
    public CPU(String name, double price, String compInterface) {
        if (price < 0) throw new IllegalArgumentException("Ціна не може бути від'ємною");
        if (name == null) throw new NullPointerException("Ім'я не може бути null");
        if (name.isBlank()) throw new IllegalArgumentException("Ім'я не може бути пустим");
        if (compInterface == null) throw new NullPointerException("Інтерфейс не може бути null");
        this.price = price;
        this.name = name;
        this.compInterface = CPUSocket.fromValue(compInterface);
    }

    public CPU() {}


    /**
     * Конструктор копіювання, що створює новий об'єкт CPU на основі існуючого.
     *
     * @param other об'єкт CPU, з якого копіюються дані
     */
    public CPU(CPU other) {
        if (other == null) throw new NullPointerException("Об'єкт для копіювання не може бути null");
        this.name = other.name;
        this.price = other.price;
        this.id = other.id;
    }

    /**
     * Повертає ціну процесора.
     *
     * @return ціна процесора
     */
    public double getPrice() {
        return price;
    }

    /**
     * Повертає назву процесора.
     *
     * @return назва процесора
     */
    public String getName() {
        return name;
    }

    /**
     * Повертає рядкове представлення об'єкта CPU.
     */
    @Override
    public String toString() {
        return "CPU{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CPUSocket getCompInterface() {
        return compInterface;
    }


    /**
     * Порівнює об'єкт CPU з іншим об'єктом на рівність.
     *
     * @param o об'єкт для порівняння
     * @return true якщо об'єкти рівні, false в іншому випадку
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CPU cpu = (CPU) o;
        return Double.compare(price, cpu.price) == 0 && Objects.equals(name, cpu.name);
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