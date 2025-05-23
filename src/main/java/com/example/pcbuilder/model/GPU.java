package com.example.pcbuilder.model;

import com.example.pcbuilder.model.enums.GPUInterface;
import jakarta.persistence.*;

import java.util.Objects;

/**
 * Клас, що представляє відеокарту (GPU) комп'ютера.
 * Зберігає інформацію про модель відеокарти та її вартість.
 */
@Entity
public class GPU {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    @Enumerated(EnumType.STRING)
    private GPUInterface compInterface;

    /**
     * Основний конструктор для створення об'єкта відеокарти.
     *
     * @param name           назва моделі відеокарти (не може бути null або пустою)
     * @param price          вартість відеокарти (має бути не менше 0)
     * @param compInterface  інтерфейс відеокарти (не може бути null)
     * @throws IllegalArgumentException якщо ціна від'ємна або назва пуста
     * @throws NullPointerException     якщо назва або інтерфейс є null
     */
    public GPU(String name, double price, String compInterface) {
        if (price < 0) throw new IllegalArgumentException("Ціна не може бути від'ємною");
        if (name == null) throw new NullPointerException("Ім'я не може бути null");
        if (name.isBlank()) throw new IllegalArgumentException("Ім'я не може бути пустим");
        if (compInterface == null) throw new NullPointerException("Інтерфейс не може бути null");
        this.price = price;
        this.name = name;
        this.compInterface = GPUInterface.fromValue(compInterface);
    }

    public GPU(){

    }


    /**
     * Конструктор копіювання, який створює нову відеокарту на основі іншої.
     *
     * @param other об'єкт GPU, дані якого копіюються
     */
    public GPU(GPU other) {
        if (other == null) throw new NullPointerException("Об'єкт для копіювання не може бути null");
        this.name = other.name;
        this.price = other.price;
        this.id = other.id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /**
     * Повертає ціну відеокарти.
     *
     * @return ціна відеокарти (тип double)
     */
    public double getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Повертає назву відеокарти.
     *
     * @return назва відеокарти (тип String)
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public GPUInterface getCompInterface() {
        return compInterface;
    }

    /**
     * Повертає рядкове представлення об'єкта GPU.
     */
    @Override
    public String toString() {
        return "GPU{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    /**
     * Порівнює об'єкт GPU з іншим об'єктом на рівність.
     *
     * @param o об'єкт для порівняння
     * @return true якщо об'єкти рівні, false в іншому випадку
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GPU gpu = (GPU) o;
        return Double.compare(price, gpu.price) == 0 && Objects.equals(name, gpu.name);
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
