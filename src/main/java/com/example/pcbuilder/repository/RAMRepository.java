package com.example.pcbuilder.repository;

import com.example.pcbuilder.model.RAM;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторій для сутності {@link RAM}.
 * Надає механізми доступу до даних для об'єктів оперативної пам'яті.
 * Розширює {@link JpaRepository}, щоб успадкувати стандартні операції CRUD
 * (Create, Read, Update, Delete) для сутності {@link RAM} з ідентифікатором типу {@link Long}.
 */
public interface RAMRepository extends JpaRepository<RAM, Long> {
}