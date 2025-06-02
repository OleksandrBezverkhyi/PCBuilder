package com.example.pcbuilder.service;

import com.example.pcbuilder.model.*;
import com.example.pcbuilder.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * **Сервісний клас для управління даними компонентів ПК.**
 * Цей сервіс надає методи для отримання інформації про окремі компоненти ПК
 * за їхнім унікальним ідентифікатором (ID) з відповідних репозиторіїв.
 * Він слугує проміжним шаром між контролерами та рівнями доступу до даних.
 */
@Service
public class PcBuilderService {

    @Autowired
    private CPURepository cpuRepository;

    @Autowired
    private GPURepository gpuRepository;

    @Autowired
    private RAMRepository ramRepository;

    @Autowired
    private StorageRepository storageRepository;

    @Autowired
    private MotherboardRepository motherboardRepository;

    @Autowired
    private PSURepository psuRepository;

    @Autowired
    private CaseRepository pcCaseRepository;

    /**
     * **Отримує об'єкт CPU за його ідентифікатором.**
     *
     * @param id Унікальний ідентифікатор процесора (CPU).
     * @return Об'єкт {@link CPU}, якщо знайдено, або `null`, якщо процесор з таким ID не існує.
     */
    public CPU getCpuById(Long id) {
        Optional<CPU> cpuOptional = cpuRepository.findById(id);
        return cpuOptional.orElse(null);
    }

    /**
     * **Отримує об'єкт GPU за його ідентифікатором.**
     *
     * @param id Унікальний ідентифікатор відеокарти (GPU).
     * @return Об'єкт {@link GPU}, якщо знайдено, або `null`, якщо відеокарта з таким ID не існує.
     */
    public GPU getGpuById(Long id) {
        Optional<GPU> gpuOptional = gpuRepository.findById(id);
        return gpuOptional.orElse(null);
    }

    /**
     * **Отримує об'єкт RAM за його ідентифікатором.**
     *
     * @param id Унікальний ідентифікатор оперативної пам'яті (RAM).
     * @return Об'єкт {@link RAM}, якщо знайдено, або `null`, якщо оперативна пам'ять з таким ID не існує.
     */
    public RAM getRamById(Long id) {
        Optional<RAM> ramOptional = ramRepository.findById(id);
        return ramOptional.orElse(null);
    }

    /**
     * **Отримує об'єкт Storage за його ідентифікатором.**
     *
     * @param id Унікальний ідентифікатор пристрою зберігання даних (Storage).
     * @return Об'єкт {@link Storage}, якщо знайдено, або `null`, якщо пристрій зберігання даних з таким ID не існує.
     */
    public Storage getStorageById(Long id) {
        Optional<Storage> storageOptional = storageRepository.findById(id);
        return storageOptional.orElse(null);
    }

    /**
     * **Отримує об'єкт Motherboard за його ідентифікатором.**
     *
     * @param id Унікальний ідентифікатор материнської плати (Motherboard).
     * @return Об'єкт {@link Motherboard}, якщо знайдено, або `null`, якщо материнська плата з таким ID не існує.
     */
    public Motherboard getMotherboardById(Long id) {
        Optional<Motherboard> motherboardOptional = motherboardRepository.findById(id);
        return motherboardOptional.orElse(null);
    }

    /**
     * **Отримує об'єкт PSU за його ідентифікатором.**
     *
     * @param id Унікальний ідентифікатор блока живлення (PSU).
     * @return Об'єкт {@link PSU}, якщо знайдено, або `null`, якщо блок живлення з таким ID не існує.
     */
    public PSU getPsuById(Long id) {
        Optional<PSU> psuOptional = psuRepository.findById(id);
        return psuOptional.orElse(null);
    }

    /**
     * **Отримує об'єкт Case за його ідентифікатором.**
     *
     * @param id Унікальний ідентифікатор корпусу ПК (Case).
     * @return Об'єкт {@link Case}, якщо знайдено, або `null`, якщо корпус ПК з таким ID не існує.
     */
    public Case getCaseById(Long id) {
        Optional<Case> caseOptional = pcCaseRepository.findById(id);
        return caseOptional.orElse(null);
    }
}