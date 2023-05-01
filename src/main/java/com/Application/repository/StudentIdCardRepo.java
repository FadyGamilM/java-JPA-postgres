package com.Application.repository;

import com.Application.domain.StudentIdCard;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentIdCardRepo extends JpaRepository<StudentIdCard, Long> {
    @Query(value = "SELECT * FROM student_id_card AS SIC JOIN Student AS S ON SIC.student_id = S.id WHERE SIC.student_id = ?1 ", nativeQuery = true)
    Optional<StudentIdCard> GetStudentIdentificationCardGivenStudentId (Long studentId);
}
