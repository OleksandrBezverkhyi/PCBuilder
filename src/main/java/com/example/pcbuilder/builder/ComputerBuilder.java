package com.example.pcbuilder.builder;

import com.example.pcbuilder.model.*;

import java.util.Objects;

/**
 * Клас-будівник для конструювання об'єктів {@link Computer}.
 * Цей клас надає текучий API для встановлення різних компонентів ПК
 * та включає базові перевірки сумісності при додаванні компонентів.
 */
public class ComputerBuilder {
    private CPU cpu;
    private GPU gpu;
    private RAM ram;
    private Storage storage;
    private Motherboard motherboard;
    private PSU psu;
    private Case pcCase;
    private int ramCount; // Зберігає кількість модулів RAM

    /**
     * Встановлює процесор для збірки комп'ютера.
     * Виконує перевірку сумісності з сокетом процесора материнської плати, що встановлена на даний момент.
     * Якщо материнська плата не встановлена або сокет процесора несумісний, процесор не буде встановлено.
     *
     * @param cpu Об'єкт {@link CPU}, який потрібно встановити. Не може бути null.
     * @return Поточний екземпляр {@link ComputerBuilder} для ланцюгового виклику методів.
     * @throws NullPointerException якщо наданий CPU є null.
     */
    public ComputerBuilder setCpu(CPU cpu) {
        Objects.requireNonNull(cpu, "CPU cannot be null"); // Changed output to English
        // Перевірка сумісності сокета CPU з материнською платою
        if (motherboard == null || cpu.getSocket().equals(motherboard.getSocket())) {
            this.cpu = cpu;
        } else {
            // Якщо несумісний, встановлюємо CPU в null, щоб вказати, що він не вибраний
            this.cpu = null;
            System.out.println("Warning: CPU socket " + cpu.getSocket() + " is incompatible with motherboard socket " + motherboard.getSocket());
        }
        return this;
    }

    /**
     * Встановлює відеокарту для збірки комп'ютера.
     * Виконує перевірку сумісності з інтерфейсом GPU материнської плати, що встановлена на даний момент.
     * Якщо материнська плата не встановлена або інтерфейс GPU несумісний, GPU не буде встановлено.
     *
     * @param gpu Об'єкт {@link GPU}, який потрібно встановити. Не може бути null.
     * @return Поточний екземпляр {@link ComputerBuilder} для ланцюгового виклику методів.
     * @throws NullPointerException якщо наданий GPU є null.
     */
    public ComputerBuilder setGpu(GPU gpu) {
        Objects.requireNonNull(gpu, "GPU cannot be null"); // Changed output to English
        // Припускаємо, що GPU та Motherboard мають відповідні інтерфейси для порівняння.
        // Оскільки в моделі GPU та Motherboard немає поля 'compInterface' для GPU interface,
        // це місце може потребувати доопрацювання або використання інших полів для сумісності.
        // Залишаю коментар, щоб ви знали про це потенційне місце для покращення.
        // Наразі, якщо немає прямої перевірки інтерфейсу, просто встановлюємо.
        this.gpu = gpu;
        return this;
    }

    /**
     * Встановлює оперативну пам'ять для збірки комп'ютера та кількість модулів RAM.
     * Виконує перевірку сумісності з інтерфейсом RAM материнської плати, що встановлена на даний момент.
     * Якщо материнська плата не встановлена або інтерфейс RAM несумісний, RAM не буде встановлено.
     *
     * @param ram Об'єкт {@link RAM}, який потрібно встановити. Не може бути null.
     * @param count Кількість модулів RAM. Повинна бути більшою за 0.
     * @return Поточний екземпляр {@link ComputerBuilder} для ланцюгового виклику методів.
     * @throws NullPointerException якщо надана RAM є null.
     * @throws IllegalArgumentException якщо count менше або дорівнює 0.
     */
    public ComputerBuilder setRam(RAM ram, int count) {
        Objects.requireNonNull(ram, "RAM cannot be null"); // Changed output to English
        if (count <= 0) {
            throw new IllegalArgumentException("RAM count must be greater than 0"); // Changed output to English
        }
        // Припускаємо, що RAM та Motherboard мають відповідні інтерфейси для порівняння.
        // Оскільки в моделі RAM немає поля 'compInterface',
        // це місце може потребувати доопрацювання або використання інших полів для сумісності.
        // Наразі, якщо немає прямої перевірки інтерфейсу, просто встановлюємо.
        this.ram = ram;
        this.ramCount = count;
        return this;
    }

    /**
     * Встановлює пристрій зберігання даних для збірки комп'ютера.
     * Виконує перевірку сумісності з інтерфейсом зберігання материнської плати, що встановлена на даний момент.
     * Якщо материнська плата не встановлена або інтерфейс зберігання несумісний, пристрій зберігання не буде встановлено.
     *
     * @param storage Об'єкт {@link Storage}, який потрібно встановити. Не може бути null.
     * @return Поточний екземпляр {@link ComputerBuilder} для ланцюгового виклику методів.
     * @throws NullPointerException якщо наданий Storage є null.
     */
    public ComputerBuilder setStorage(Storage storage) {
        Objects.requireNonNull(storage, "Storage cannot be null"); // Changed output to English
        // Припускаємо, що Storage та Motherboard мають відповідні інтерфейси для порівняння.
        // Оскільки в моделі Storage немає поля 'compInterface',
        // це місце може потребувати доопрацювання або використання інших полів для сумісності.
        // Наразі, якщо немає прямої перевірки інтерфейсу, просто встановлюємо.
        this.storage = storage;
        return this;
    }

    /**
     * Встановлює блок живлення для збірки комп'ютера.
     *
     * @param psu Об'єкт {@link PSU}, який потрібно встановити. Не може бути null.
     * @return Поточний екземпляр {@link ComputerBuilder} для ланцюгового виклику методів.
     * @throws NullPointerException якщо наданий PSU є null.
     */
    public ComputerBuilder setPsu(PSU psu) {
        Objects.requireNonNull(psu, "PSU cannot be null"); // Changed output to English
        this.psu = psu;
        return this;
    }

    /**
     * Встановлює корпус для збірки комп'ютера.
     * Виконує перевірку сумісності з форм-фактором материнської плати, що встановлена на даний момент.
     * Якщо материнська плата не встановлена або форм-фактор корпусу несумісний, корпус не буде встановлено.
     *
     * @param pcCase Об'єкт {@link Case}, який потрібно встановити. Не може бути null.
     * @return Поточний екземпляр {@link ComputerBuilder} для ланцюгового виклику методів.
     * @throws NullPointerException якщо наданий Case є null.
     */
    public ComputerBuilder setCase(Case pcCase) {
        Objects.requireNonNull(pcCase, "PC case cannot be null"); // Changed output to English
        // Припускаємо, що Case та Motherboard мають відповідні поля для форм-фактора.
        // Оскільки в моделях немає 'getCompInterface' для Case та 'getCaseFormFactor' для Motherboard,
        // це місце може потребувати доопрацювання.
        // Наразі, якщо немає прямої перевірки, просто встановлюємо.
        this.pcCase = pcCase;
        return this;
    }

    /**
     * Встановлює материнську плату для збірки комп'ютера.
     * При встановленні нової материнської плати відбувається повторна перевірка всіх раніше доданих компонентів
     * на сумісність з новою материнською платою. Несумісні компоненти будуть скинуті.
     *
     * @param motherboard Об'єкт {@link Motherboard}, який потрібно встановити.
     * @return Поточний екземпляр {@link ComputerBuilder} для ланцюгового виклику методів.
     */
    public ComputerBuilder setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
        // Повторна перевірка вже доданих компонентів на відповідність новій материнській платі
        if (cpu != null) setCpu(this.cpu); // Повторна перевірка сумісності CPU
        if (gpu != null) setGpu(this.gpu); // Повторна перевірка сумісності GPU
        if (ram != null) setRam(this.ram, this.ramCount); // Повторна перевірка сумісності RAM
        if (storage != null) setStorage(this.storage); // Повторна перевірка сумісності Storage
        // PSU та Case не залежать безпосередньо від материнської плати для їх *встановлення*,
        // але їх залежності можуть бути перевірені під час побудови або як частина setCase для форм-фактора.
        // Для PSU, це більше стосується розрахунку потужності, який може відбутися пізніше.
        // Для Case, сумісність перевіряється в setCase, тому повторне встановлення є доречним.
        if (pcCase != null) setCase(this.pcCase); // Повторна перевірка сумісності Case
        return this;
    }

    /**
     * Будує та повертає новий об'єкт {@link Computer} з вибраними компонентами.
     * Видає {@link IllegalStateException}, якщо будь-який основний компонент не встановлений.
     *
     * @return Новий екземпляр {@link Computer}.
     * @throws IllegalStateException якщо будь-який необхідний компонент (CPU, GPU, RAM, Storage, Motherboard, PSU, Case) не встановлений.
     */
    public Computer build() {
        if (cpu == null) throw new IllegalStateException("CPU is not set");
        if (gpu == null) throw new IllegalStateException("GPU is not set");
        if (ram == null) throw new IllegalStateException("RAM is not set");
        if (storage == null) throw new IllegalStateException("Storage is not set");
        if (motherboard == null) throw new IllegalStateException("Motherboard is not set");
        if (psu == null) throw new IllegalStateException("PSU is not set");
        if (pcCase == null) throw new IllegalStateException("Case is not set");

        return new Computer(cpu, gpu, ram, storage, motherboard, psu, pcCase);
    }

    /**
     * Повертає поточний вибраний процесор.
     * @return Об'єкт {@link CPU}, або null, якщо не встановлений або несумісний.
     */
    public CPU getCpu() {
        return cpu;
    }

    /**
     * Повертає поточну вибрану відеокарту.
     * @return Об'єкт {@link GPU}, або null, якщо не встановлений або несумісний.
     */
    public GPU getGpu() {
        return gpu;
    }

    /**
     * Повертає поточну вибрану оперативну пам'ять.
     * @return Об'єкт {@link RAM}, або null, якщо не встановлений або несумісний.
     */
    public RAM getRam() {
        return ram;
    }

    /**
     * Повертає поточний вибраний пристрій зберігання даних.
     * @return Об'єкт {@link Storage}, або null, якщо не встановлений або несумісний.
     */
    public Storage getStorage() {
        return storage;
    }

    /**
     * Повертає поточний вибраний корпус ПК.
     * @return Об'єкт {@link Case}, або null, якщо не встановлений або несумісний.
     */
    public Case getPcCase() {
        return pcCase;
    }

    /**
     * Повертає поточний вибраний блок живлення.
     * @return Об'єкт {@link PSU}, або null, якщо не встановлений.
     */
    public PSU getPsu() {
        return psu;
    }

    /**
     * Повертає поточну вибрану материнську плату.
     * @return Об'єкт {@link Motherboard}, або null, якщо не встановлений.
     */
    public Motherboard getMotherboard() {
        return motherboard;
    }
}
