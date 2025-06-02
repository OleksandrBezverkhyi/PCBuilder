package com.example.pcbuilder.controller;

import com.example.pcbuilder.dto.BuildRequest;
import com.example.pcbuilder.dto.BuildResponse;
import com.example.pcbuilder.model.*;
import com.example.pcbuilder.service.PcBuilderService;
import com.example.pcbuilder.builder.Computer;
import com.example.pcbuilder.builder.ComputerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * **REST-контролер для обробки запитів на збірку ПК.**
 * Цей контролер надає кінцеву точку, що дозволяє користувачам надсилати свій вибір компонентів ПК,
 * які потім **перевіряються на сумісність** та збираються в об'єкт {@link Computer}
 * за допомогою шаблону **{@link ComputerBuilder}**. Він повертає вибрані компоненти,
 * загальну вартість та будь-які виявлені проблеми сумісності.
 */
@RestController
@RequestMapping("/api/build")
public class BuildController {

    @Autowired
    private PcBuilderService pcBuilderService;

    /**
     * **Обробляє POST-запити для збірки ПК.**
     * Метод приймає об'єкт {@link BuildRequest}, що містить ідентифікатори бажаних компонентів,
     * отримує їхні деталі та намагається зібрати об'єкт {@link Computer} за допомогою **{@link ComputerBuilder}**.
     * **Перевірки сумісності** виконуються під час процесу збірки, і будь-які виявлені проблеми
     * відображаються у {@link BuildResponse}.
     *
     * @param request Об'єкт {@link BuildRequest} з ідентифікаторами компонентів для збірки ПК.
     * @return Об'єкт {@link BuildResponse}, що містить деталі вибраних компонентів,
     * загальну вартість та будь-які виявлені проблеми сумісності.
     */
    @PostMapping
    public BuildResponse buildPC(@RequestBody BuildRequest request) {
        Map<String, String> selectedComponents = new LinkedHashMap<>();
        Map<String, String> compatibilityIssues = new LinkedHashMap<>();
        double totalPrice = 0;

        try {
            // Перевіряємо, чи всі необхідні ID компонентів надані в запиті
            if (request.MOTHERBOARD == null) throw new IllegalArgumentException("Потрібен ID материнської плати.");
            if (request.CPU == null) throw new IllegalArgumentException("Потрібен ID процесора (CPU).");
            if (request.GPU == null) throw new IllegalArgumentException("Потрібен ID відеокарти (GPU).");
            if (request.RAM == null) throw new IllegalArgumentException("Потрібен ID оперативної пам'яті (RAM).");
            if (request.STORAGE == null) throw new IllegalArgumentException("Потрібен ID пристрою зберігання даних.");
            if (request.PSU == null) throw new IllegalArgumentException("Потрібен ID блока живлення (PSU).");
            if (request.CASE == null) throw new IllegalArgumentException("Потрібен ID корпусу.");

            // Отримуємо деталі компонентів від сервісу за наданими ID
            Motherboard motherboard = pcBuilderService.getMotherboardById(request.MOTHERBOARD);
            if (motherboard == null) throw new IllegalArgumentException("Материнська плата не знайдена за ID: " + request.MOTHERBOARD);

            CPU cpu = pcBuilderService.getCpuById(request.CPU);
            if (cpu == null) throw new IllegalArgumentException("Процесор не знайдений за ID: " + request.CPU);

            GPU gpu = pcBuilderService.getGpuById(request.GPU);
            if (gpu == null) throw new IllegalArgumentException("Відеокарта не знайдена за ID: " + request.GPU);

            RAM ram = pcBuilderService.getRamById(request.RAM);
            if (ram == null) throw new IllegalArgumentException("Оперативна пам'ять не знайдена за ID: " + request.RAM);

            Storage storage = pcBuilderService.getStorageById(request.STORAGE);
            if (storage == null) throw new IllegalArgumentException("Пристрій зберігання даних не знайдений за ID: " + request.STORAGE);

            PSU psu = pcBuilderService.getPsuById(request.PSU);
            if (psu == null) throw new IllegalArgumentException("Блок живлення не знайдений за ID: " + request.PSU);

            Case pcCase = pcBuilderService.getCaseById(request.CASE);
            if (pcCase == null) throw new IllegalArgumentException("Корпус не знайдений за ID: " + request.CASE);

            // Використовуємо ComputerBuilder для збірки ПК.
            // Материнська плата встановлюється першою, оскільки сумісність інших компонентів часто залежить від неї.
            ComputerBuilder computerBuilder = new ComputerBuilder()
                    .setMotherboard(motherboard)
                    .setCpu(cpu)
                    .setGpu(gpu)
                    .setRam(ram, 1) // Припускаємо 1 модуль RAM за замовчуванням для початкової логіки збірки
                    .setStorage(storage)
                    .setPsu(psu)
                    .setCase(pcCase);

            // Після спроби встановити компоненти в білдері, перевіряємо, які з них були фактично встановлені.
            // Якщо компонент є null в білдері, це означає, що логіка білдера виявила проблему сумісності.
            if (computerBuilder.getCpu() == null) {
                compatibilityIssues.put("CPU", "CPU is incompatible with the selected motherboard socket.");
            }
            if (computerBuilder.getGpu() == null) {
                compatibilityIssues.put("GPU", "GPU is incompatible with the selected motherboard interface.");
            }
            if (computerBuilder.getRam() == null) {
                compatibilityIssues.put("RAM", "RAM is incompatible with the selected motherboard RAM interface.");
            }
            if (computerBuilder.getStorage() == null) {
                compatibilityIssues.put("Storage", "Storage device is incompatible with the selected motherboard storage interface.");
            }
            if (computerBuilder.getPcCase() == null) {
                compatibilityIssues.put("Case", "Case form factor is incompatible with the selected motherboard.");
            }

            // Якщо білдер не виявив проблем сумісності, продовжуємо завершення збірки.
            if (compatibilityIssues.isEmpty()) {
                try {
                    // Спроба зібрати комп'ютер. Це викине IllegalStateException, якщо будь-який необхідний компонент все ще відсутній
                    // (чого не повинно статися, якщо попередні перевірки були ретельними).
                    Computer computer = computerBuilder.build();

                    // Додаємо успішно вибрані компоненти та розраховуємо загальну вартість
                    selectedComponents.put("Motherboard", motherboard.getName());
                    selectedComponents.put("CPU", cpu.getName());
                    selectedComponents.put("GPU", gpu.getName());
                    selectedComponents.put("RAM", ram.getName());
                    selectedComponents.put("Storage", storage.getName());
                    selectedComponents.put("PSU", psu.getName());
                    selectedComponents.put("Case", pcCase.getName());

                    totalPrice = motherboard.getPrice() +
                            cpu.getPrice() +
                            gpu.getPrice() +
                            ram.getPrice() + // Примітка: Якщо кількість RAM впливає на ціну, це слід врахувати тут.
                            storage.getPrice() +
                            psu.getPrice() +
                            pcCase.getPrice();
                } catch (IllegalStateException e) {
                    // Перехоплюємо будь-які остаточні помилки перевірки під час збірки з методу ComputerBuilder.build().

                    compatibilityIssues.put("Build Error", e.getMessage());
                }
            }

            // Повертаємо відповідь з вибраними компонентами, загальною ціною та будь-якими проблемами сумісності.
            return new BuildResponse(selectedComponents, totalPrice, compatibilityIssues);
        } catch (IllegalArgumentException e) {
            // Обробляємо випадки, коли вхідні ID відсутні або компоненти не знайдено.
            compatibilityIssues.put("Input Error", e.getMessage());
            return new BuildResponse(selectedComponents, totalPrice, compatibilityIssues);
        } catch (Exception e) {

            // Перехоплюємо будь-які несподівані винятки під час процесу.
            compatibilityIssues.put("Unexpected Error", "An unexpected error occurred: " + e.getMessage());
            // Логуємо виняток для налагодження (наприклад, за допомогою логера, такого як SLF4J)
            System.err.println("An unexpected error occurred during PC build: " + e.getMessage());
            return new BuildResponse(selectedComponents, totalPrice, compatibilityIssues);
        }
    }
}