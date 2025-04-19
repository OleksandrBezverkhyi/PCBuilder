package com.example.pcbuilder.repository;

import com.example.pcbuilder.model.Storage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageRepository extends JpaRepository<Storage, Long> {
}