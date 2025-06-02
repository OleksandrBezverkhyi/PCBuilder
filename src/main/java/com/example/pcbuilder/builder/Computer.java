package com.example.pcbuilder.builder;

import com.example.pcbuilder.model.*;

/**
 * Представляє повну збірку комп'ютера, інкапсулюючи всі вибрані компоненти.
 */
public class Computer {
    private final CPU cpu;
    private final GPU gpu;
    private final RAM ram;
    private final Storage storage;
    private final Motherboard motherboard;
    private final PSU psu;
    private final Case pcCase;

    /**
     * Конструює новий екземпляр Computer з вказаними компонентами.
     *
     * @param cpu Процесор ({@link CPU}), обраний для комп'ютера.
     * @param gpu Відеокарта ({@link GPU}), обрана для комп'ютера.
     * @param ram Оперативна пам'ять ({@link RAM}), обрана для комп'ютера.
     * @param storage Пристрій зберігання даних (наприклад, SSD, HDD) ({@link Storage}), обраний для комп'ютера.
     * @param motherboard Материнська плата ({@link Motherboard}), обрана для комп'ютера.
     * @param psu Блок живлення ({@link PSU}), обраний для комп'ютера.
     * @param pcCase Корпус ({@link Case}), обраний для комп'ютера.
     */
    public Computer(CPU cpu, GPU gpu, RAM ram, Storage storage, Motherboard motherboard, PSU psu, Case pcCase) {
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.storage = storage;
        this.motherboard = motherboard;
        this.psu = psu;
        this.pcCase = pcCase;
    }

    /**
     * Повертає процесор, обраний для цієї збірки комп'ютера.
     *
     * @return Об'єкт {@link CPU}.
     */
    public CPU getCpu() {
        return cpu;
    }

    /**
     * Повертає відеокарту, обрану для цієї збірки комп'ютера.
     *
     * @return Об'єкт {@link GPU}.
     */
    public GPU getGpu() {
        return gpu;
    }

    /**
     * Повертає оперативну пам'ять, обрану для цієї збірки комп'ютера.
     *
     * @return Об'єкт {@link RAM}.
     */
    public RAM getRam() {
        return ram;
    }

    /**
     * Повертає пристрій зберігання даних, обраний для цієї збірки комп'ютера.
     *
     * @return Об'єкт {@link Storage}.
     */
    public Storage getStorage() {
        return storage;
    }

    /**
     * Повертає материнську плату, обрану для цієї збірки комп'ютера.
     *
     * @return Об'єкт {@link Motherboard}.
     */
    public Motherboard getMotherboard() {
        return motherboard;
    }

    /**
     * Повертає блок живлення, обраний для цієї збірки комп'ютера.
     *
     * @return Об'єкт {@link PSU}.
     */
    public PSU getPsu() {
        return psu;
    }

    /**
     * Повертає корпус, обраний для цієї збірки комп'ютера.
     *
     * @return Об'єкт {@link Case}.
     */
    public Case getPcCase() {
        return pcCase;
    }

    /**
     * Повертає рядкове представлення об'єкта Computer,
     * перераховуючи всі його вибрані компоненти.
     *
     * @return Рядок, що містить деталі компонентів комп'ютера.
     */
    @Override
    public String toString() {
        return "Computer{" +
                "cpu=" + cpu +
                ", gpu=" + gpu +
                ", ram=" + ram +
                ", storage=" + storage +
                ", motherboard=" + motherboard +
                ", psu=" + psu +
                ", pcCase=" + pcCase +
                '}';
    }
}
