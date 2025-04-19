package com.example.pcbuilder.repository;

import com.example.pcbuilder.model.Case;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseRepository extends JpaRepository<Case, Long> {
}
