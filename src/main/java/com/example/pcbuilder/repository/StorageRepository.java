package com.example.pcbuilder.repository;

import com.example.pcbuilder.model.Storage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторій для сутності {@link Storage}.
 * Надає механізми доступу до даних для об'єктів пристроїв зберігання даних.
 * Розширює {@link JpaRepository}, щоб успадкувати стандартні операції CRUD
 * (Create, Read, Update, Delete) для сутності {@link Storage} з ідентифікатором типу {@link Long}.
 */
public interface StorageRepository extends JpaRepository<Storage, Long> {
}