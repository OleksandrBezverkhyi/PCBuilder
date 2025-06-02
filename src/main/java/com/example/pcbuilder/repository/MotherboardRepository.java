package com.example.pcbuilder.repository;

import com.example.pcbuilder.model.Motherboard;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * **Репозиторій для доступу до даних про материнські плати.**
 * Цей інтерфейс розширює {@link JpaRepository}, надаючи стандартні операції CRUD
 * (створення, читання, оновлення, видалення) для сутності {@link Motherboard}.
 * Завдяки Spring Data JPA, вам не потрібно писати реалізацію цих методів;
 * Spring автоматично надасть її під час виконання.
 */
public interface MotherboardRepository extends JpaRepository<Motherboard, Long> {
}