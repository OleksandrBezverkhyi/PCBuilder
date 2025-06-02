package com.example.pcbuilder.repository;

import com.example.pcbuilder.model.Motherboard;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторій для сутності {@link Motherboard}.
 * Надає механізми доступу до даних для об'єктів материнської плати.
 * Розширює {@link JpaRepository}, щоб успадкувати стандартні операції CRUD
 * (Create, Read, Update, Delete) для сутності {@link Motherboard} з ідентифікатором типу {@link Long}.
 */
public interface MotherboardRepository extends JpaRepository<Motherboard, Long> {
}