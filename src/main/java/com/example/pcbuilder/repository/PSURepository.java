package com.example.pcbuilder.repository;

import com.example.pcbuilder.model.PSU;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторій для сутності {@link PSU}.
 * Надає механізми доступу до даних для об'єктів блоку живлення.
 * Розширює {@link JpaRepository}, щоб успадкувати стандартні операції CRUD
 * (Create, Read, Update, Delete) для сутності {@link PSU} з ідентифікатором типу {@link Long}.
 */
public interface PSURepository extends JpaRepository<PSU, Long> {
}