package com.Application.domain;

import jakarta.persistence.*;

@Entity(name = "StudentIdCard")
// the name in the @Table is the name from our ERD (mapped to the database)
@Table(name="student_id_card", uniqueConstraints = {@UniqueConstraint(name = "card_number_is_unique", columnNames = "card_number")})
public class StudentIdCard {
    // PK
    @Id
    @Column(name = "id", updatable = false)
    @SequenceGenerator(name = "stduent_id_card_seq", sequenceName = "stduent_id_card_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stduent_id_card_seq")
    private Long id;

    // FK
    @JoinColumn(
            // name of the fk column in this table
            name = "student_id",
            // in the Student table
            referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    private Student student;

    // card number is unique for each student, no 2 card has the save number
    @Column(columnDefinition = "TEXT", name = "card_number", nullable = false) // card_number is the name from our DB and also used in unqie constraint above at @Table
    private String cardNumber;

    // constructors
    public StudentIdCard(){}
    public StudentIdCard(String card) {this.cardNumber = card;}
    public StudentIdCard(String card, Student student) {
        this.cardNumber = card;
        this.student = student;
    }

    public Long getId() {
        return id;
    }
    public Student getStudent() {
        return student;
    }
    public String getCardNumber() {
        return cardNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "StudentIdCard{" +
                "id=" + id +
                ", student=" + student +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }
}
