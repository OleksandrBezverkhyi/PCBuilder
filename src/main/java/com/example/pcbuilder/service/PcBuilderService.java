package com.example.pcbuilder.service;

import com.example.pcbuilder.model.*;
import com.example.pcbuilder.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Сервісний клас для застосунку "PC Builder".
 * Цей клас надає бізнес-логіку для отримання окремих компонентів ПК за їх ідентифікатором.
 * Він взаємодіє з різними репозиторіями JPA для отримання даних компонентів з бази даних.
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
     * Отримує компонент CPU за його унікальним ідентифікатором.
     *
     * @param id Ідентифікатор CPU для отримання.
     * @return Об'єкт {@link CPU}, якщо знайдено, інакше {@code null}.
     */
    public CPU getCpuById(Long id) {
        Optional<CPU> cpuOptional = cpuRepository.findById(id);
        return cpuOptional.orElse(null);
    }

    /**
     * Отримує компонент GPU за його унікальним ідентифікатором.
     *
     * @param id Ідентифікатор GPU для отримання.
     * @return Об'єкт {@link GPU}, якщо знайдено, інакше {@code null}.
     */
    public GPU getGpuById(Long id) {
        Optional<GPU> gpuOptional = gpuRepository.findById(id);
        return gpuOptional.orElse(null);
    }

    /**
     * Отримує компонент RAM за його унікальним ідентифікатором.
     *
     * @param id Ідентифікатор RAM для отримання.
     * @return Об'єкт {@link RAM}, якщо знайдено, інакше {@code null}.
     */
    public RAM getRamById(Long id) {
        Optional<RAM> ramOptional = ramRepository.findById(id);
        return ramOptional.orElse(null);
    }

    /**
     * Отримує компонент Storage за його унікальним ідентифікатором.
     *
     * @param id Ідентифікатор пристрою зберігання даних для отримання.
     * @return Об'єкт {@link Storage}, якщо знайдено, інакше {@code null}.
     */
    public Storage getStorageById(Long id) {
        Optional<Storage> storageOptional = storageRepository.findById(id);
        return storageOptional.orElse(null);
    }

    /**
     * Отримує компонент Motherboard за її унікальним ідентифікатором.
     *
     * @param id Ідентифікатор материнської плати для отримання.
     * @return Об'єкт {@link Motherboard}, якщо знайдено, інакше {@code null}.
     */
    public Motherboard getMotherboardById(Long id) {
        Optional<Motherboard> motherboardOptional = motherboardRepository.findById(id);
        return motherboardOptional.orElse(null);
    }

    /**
     * Отримує компонент PSU за його унікальним ідентифікатором.
     *
     * @param id Ідентифікатор блоку живлення для отримання.
     * @return Об'єкт {@link PSU}, якщо знайдено, інакше {@code null}.
     */
    public PSU getPsuById(Long id) {
        Optional<PSU> psuOptional = psuRepository.findById(id);
        return psuOptional.orElse(null);
    }

    /**
     * Отримує компонент Case за його унікальним ідентифікатором.
     *
     * @param id Ідентифікатор корпусу для отримання.
     * @return Об'єкт {@link Case}, якщо знайдено, інакше {@code null}.
     */
    public Case getCaseById(Long id) {
        Optional<Case> caseOptional = pcCaseRepository.findById(id);
        return caseOptional.orElse(null);
    }
}