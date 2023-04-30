package com.Application.repository;

import com.Application.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

// <TYPE_OF_ENTITY, TYPE_OF_ENTITY_PK>
public interface StudentRepo extends JpaRepository<Student, Long> {
}
