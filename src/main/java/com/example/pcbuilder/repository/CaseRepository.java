package com.example.pcbuilder.repository;

import com.example.pcbuilder.model.Case;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторій для сутності {@link Case}.
 * Надає механізми доступу до даних для об'єктів корпусу ПК.
 * Розширює {@link JpaRepository}, щоб успадкувати стандартні операції CRUD
 * (Create, Read, Update, Delete) для сутності {@link Case} з ідентифікатором типу {@link Long}.
 */
public interface CaseRepository extends JpaRepository<Case, Long> {
}