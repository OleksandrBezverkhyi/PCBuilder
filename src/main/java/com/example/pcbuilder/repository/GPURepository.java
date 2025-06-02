package com.example.pcbuilder.repository;

import com.example.pcbuilder.model.GPU;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * **Репозиторій для доступу до даних про графічні процесорні пристрої (GPU).**
 * Цей інтерфейс розширює {@link JpaRepository}, надаючи стандартні операції CRUD
 * (створення, читання, оновлення, видалення) для сутності {@link GPU}.
 * Завдяки Spring Data JPA, вам не потрібно писати реалізацію цих методів;
 * Spring автоматично надасть її під час виконання.
 */
public interface GPURepository extends JpaRepository<GPU, Long> {
}
