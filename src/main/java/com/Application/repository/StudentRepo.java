package com.Application.repository;

import com.Application.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

// <TYPE_OF_ENTITY, TYPE_OF_ENTITY_PK>
public interface StudentRepo extends JpaRepository<Student, Long> {
    // to find by one field, we just need to write this syntax
    // => [findBy][property_name]
    Optional<Student> findByEmail(String email);

    // to find by more than one field
    Optional<Student> findByFirstNameAndLastName(String firstname, String lastname);

    @Query("SELECT S " +
            "FROM Student S " + // notice that this `Student` comes from the @Table which we put above the model class
            "WHERE S.email = ?1") // ?1 because i have 1 argument to the method
    Optional<Student> GetByEmail(String studentEmail);

    @Query("SELECT S " +
            "FROM Student S " +
            "WHERE S.firstName = ?1 AND S.lastName = ?2")
    Optional<Student> GetByFirstAndLastName(String firstname, String lastname);

    // now natively not via the jqpl
    @Query(value = "SELECT * FROM Student AS S WHERE S.email = ?1", nativeQuery = true)
    Optional<Student> GetByEmailNative (String email);
}
