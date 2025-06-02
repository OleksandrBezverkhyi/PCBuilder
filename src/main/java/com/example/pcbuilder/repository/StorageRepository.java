package com.example.pcbuilder.repository;

import com.example.pcbuilder.model.Storage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * **Репозиторій для доступу до даних про пристрої зберігання даних.**
 * Цей інтерфейс розширює {@link JpaRepository}, надаючи стандартні операції CRUD
 * (створення, читання, оновлення, видалення) для сутності {@link Storage}.
 * Завдяки Spring Data JPA, вам не потрібно писати реалізацію цих методів;
 * Spring автоматично надасть її під час виконання.
 */
public interface StorageRepository extends JpaRepository<Storage, Long> {
}