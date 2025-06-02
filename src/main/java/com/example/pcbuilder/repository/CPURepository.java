package com.example.pcbuilder.repository;

import com.example.pcbuilder.model.CPU;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * **Репозиторій для доступу до даних про центральні процесорні пристрої (CPU).**
 * Цей інтерфейс розширює {@link JpaRepository}, надаючи стандартні операції CRUD
 * (створення, читання, оновлення, видалення) для сутності {@link CPU}.
 * Завдяки Spring Data JPA, вам не потрібно писати реалізацію цих методів;
 * Spring автоматично надасть її під час виконання.
 */
public interface CPURepository extends JpaRepository<CPU, Long> {
}