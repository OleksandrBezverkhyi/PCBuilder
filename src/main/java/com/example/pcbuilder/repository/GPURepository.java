package com.example.pcbuilder.repository;

import com.example.pcbuilder.model.GPU;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторій для сутності {@link GPU}.
 * Надає механізми доступу до даних для об'єктів графічного процесора (відеокарти).
 * Розширює {@link JpaRepository}, щоб успадкувати стандартні операції CRUD
 * (Create, Read, Update, Delete) для сутності {@link GPU} з ідентифікатором типу {@link Long}.
 */
public interface GPURepository extends JpaRepository<GPU, Long> {
}