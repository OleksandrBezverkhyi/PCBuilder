package com.example.pcbuilder.model;

import com.example.pcbuilder.model.enums.*;
import jakarta.persistence.*;

import java.util.ArrayList;
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
    @Enumerated(EnumType.STRING)
    CaseFormFactor caseFormFactor;
    @Enumerated(EnumType.STRING)
    CPUSocket cpuSocket;
    @Enumerated(EnumType.STRING)
    GPUInterface gpuInterface;
    @Enumerated(EnumType.STRING)
    RAMInterface ramInterface;
    @Enumerated(EnumType.STRING)
    StorageInterface storageInterface;
    int ramCount;

    /**
     * Основний конструктор для створення об'єкта материнської плати.
     *
     * @param name              назва моделі материнської плати (не може бути null або пустою)
     * @param price             вартість материнської плати (має бути не менше 0)
     * @param caseFormFactor    форм-фактор корпусу, що підтримується (не може бути null)
     * @param cpuSocket         сокет процесора (не може бути null)
     * @param gpuInterface      інтерфейс відеокарти (не може бути null)
     * @param ramInterface      інтерфейс оперативної пам'яті (не може бути null)
     * @param storageInterface  інтерфейс накопичувача (не може бути null)
     * @param ramCount          кількість підтримуваних слотів RAM (має бути > 0)
     * @throws IllegalArgumentException якщо ціна від'ємна, назва пуста або ramCount <= 0
     * @throws NullPointerException     якщо будь-який з інтерфейсів або назва є null
     */
    public Motherboard(
            String name,
            double price,
            String caseFormFactor,
            String cpuSocket,
            String gpuInterface,
            String ramInterface,
            String storageInterface,
            int ramCount
    ) {
        if (price < 0) throw new IllegalArgumentException("Ціна не може бути від'ємною");
        if (name == null) throw new NullPointerException("Ім'я не може бути null");
        if (name.isBlank()) throw new IllegalArgumentException("Ім'я не може бути пустим");

        if (caseFormFactor == null) throw new NullPointerException("CaseFormFactor не може бути null");
        if (cpuSocket == null) throw new NullPointerException("CPUSocket не може бути null");
        if (gpuInterface == null) throw new NullPointerException("GPUInterface не може бути null");
        if (ramInterface == null) throw new NullPointerException("RAMInterface не може бути null");
        if (storageInterface == null) throw new NullPointerException("StorageInterface не може бути null");

        if (ramCount <= 0) throw new IllegalArgumentException("Кількість слотів RAM має бути більшою за 0");

        this.name = name;
        this.price = price;
        this.caseFormFactor = CaseFormFactor.fromValue(caseFormFactor);
        this.cpuSocket = CPUSocket.fromValue(cpuSocket);
        this.gpuInterface = GPUInterface.fromValue(gpuInterface);
        this.ramInterface = RAMInterface.fromValue(ramInterface);
        this.storageInterface = StorageInterface.fromValue(storageInterface);
        this.ramCount = ramCount;
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

    public Long getId() {
        return id;
    }

    public CaseFormFactor getCaseFormFactor() {
        return caseFormFactor;
    }

    public CPUSocket getCpuSocket() {
        return cpuSocket;
    }

    public GPUInterface getGpuInterface() {
        return gpuInterface;
    }

    public RAMInterface getRamInterface() {
        return ramInterface;
    }

    public StorageInterface getStorageInterface() {
        return storageInterface;
    }

    public int getRAMCount() {
        return ramCount;
    }

    /**
     * Повертає рядкове представлення об'єкта Motherboard.
     */
    @Override
    public String toString() {
        return "Motherboard{" +
                "id=" + id +
                ", name='" + name + '\'' +
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