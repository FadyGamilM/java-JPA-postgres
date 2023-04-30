package com.Application;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name="Student")
public class Student {
    //➜ props of the java class
    @Id
    @SequenceGenerator(
            name="student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1 // how  much the sequence will increase by
    )
    // to specify how this value will be generated
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"


    )
    private Long id;
    private String firstName;
    private String lastname;
    private Integer age;
    private String email;


    // constructor
    public Student(Long id, String firstName, String lastName, String email, Integer age){
        this.age = age;
        this.email = email;
        this.firstName = firstName;
        this.lastname = lastname;
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLastname(String lastname) {
        lastname = lastname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(firstName, student.firstName) && Objects.equals(lastname, student.lastname) && Objects.equals(age, student.age) && Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastname, age, email);
    }

}
