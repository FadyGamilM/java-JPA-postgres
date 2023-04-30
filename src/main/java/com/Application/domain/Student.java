package com.Application.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name="Student")
@Table(name="student", uniqueConstraints ={@UniqueConstraint(name ="student_email_is_unique", columnNames ="email" )})
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
    @Column(name="first_name", nullable = false, columnDefinition ="TEXT")
    private String firstName;

    @Column(name="last_name", nullable = false, columnDefinition ="TEXT")
    private String lastName;

    @Column(name="age", nullable = false)
    private Integer age;

    @Column(name="email", nullable = false, columnDefinition ="TEXT")
    private String email;


    // constructor
    public Student(){}
    public Student(String firstName, String lastName, String email, Integer age){
        this.age = age;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
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
        return lastName;
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
        lastName = lastname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(age, student.age) && Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, age, email);
    }

}