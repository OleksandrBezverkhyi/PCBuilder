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
    private GPUInterface compInterface;


    /**
     * Конструктор, який ініціалізує відеокарту з вказаною назвою та ціною.
     *
     * @param name  назва відеокарти (наприклад, "NVIDIA RTX 4090")
     * @param price ціна відеокарти у грошових одиницях
     * @throws IllegalArgumentException якщо ціна від'ємна або назва пуста
     * @throws NullPointerException якщо назва є null
     */
    public GPU(String name, double price) {
        if (price < 0) throw new IllegalArgumentException("Ціна не може бути від'ємною");
        if (name == null) throw new NullPointerException("Ім'я не може бути null");
        if (name.isBlank()) throw new IllegalArgumentException("Ім'я не може бути пустим");
        this.name = name;
        this.price = price;
    }

    public GPU() {}

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

    /**
     * Повертає ціну відеокарти.
     *
     * @return ціна відеокарти (тип double)
     */
    public double getPrice() {
        return price;
    }

    /**
     * Повертає назву відеокарти.
     *
     * @return назва відеокарти (тип String)
     */
    public String getName() {
        return name;
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
