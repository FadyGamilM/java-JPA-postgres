package com.Application.repository;

import com.Application.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// <TYPE_OF_ENTITY, TYPE_OF_ENTITY_PK>
public interface StudentRepo extends JpaRepository<Student, Long> {
    // to find by one field, we just need to write this syntax
    // => [findBy][property_name]
    Optional<Student> findByEmail(String email);

    // to find by more than one field
    Optional<Student> findByFirstNameAndLastName(String firstname, String lastname);
}
