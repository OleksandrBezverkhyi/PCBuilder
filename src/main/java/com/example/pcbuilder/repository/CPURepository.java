package com.example.pcbuilder.repository;

import com.example.pcbuilder.model.CPU;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторій для сутності {@link CPU}.
 * Надає механізми доступу до даних для об'єктів центрального процесора.
 * Розширює {@link JpaRepository}, щоб успадкувати стандартні операції CRUD
 * (Create, Read, Update, Delete) для сутності {@link CPU} з ідентифікатором типу {@link Long}.
 */
public interface CPURepository extends JpaRepository<CPU, Long> {
}