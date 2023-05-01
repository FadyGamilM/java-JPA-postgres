package com.Application.repository;

import com.Application.domain.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
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

    // the @Query notation is used for queries which returns something from our database
    /*
    but for queries such as DELETE UPDATE INSERT, we need to notify our JPA repo that we
    won't receive something from the database to map it to our classes, so we will use
    two notations :
    1 -> @Modifying
    2 -> @Transactional
    */
    @Transactional
    @Modifying
    // receive integer 0 or 1 indicating that the process is succeed or failed
    @Query(value = "DELETE FROM Student WHERE id = ?1", nativeQuery = true)
    int DeleteStudentByStudentId(Long studentId);

    // TODO => sorting metohd
    @Query(value="SELECT S.first_name FROM Student AS S ORDER BY S.first_name", nativeQuery = true)
    List<String> SortByFirstName();
}
