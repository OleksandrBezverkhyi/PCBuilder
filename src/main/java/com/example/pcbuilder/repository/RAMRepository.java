package com.example.pcbuilder.repository;

import com.example.pcbuilder.model.RAM;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * **Репозиторій для доступу до даних про оперативну пам'ять (RAM).**
 * Цей інтерфейс розширює {@link JpaRepository}, надаючи стандартні операції CRUD
 * (створення, читання, оновлення, видалення) для сутності {@link RAM}.
 * Завдяки Spring Data JPA, вам не потрібно писати реалізацію цих методів;
 * Spring автоматично надасть її під час виконання.
 */
public interface RAMRepository extends JpaRepository<RAM, Long> {
}