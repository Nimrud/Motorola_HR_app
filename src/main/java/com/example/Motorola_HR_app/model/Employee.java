package com.example.Motorola_HR_app.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Imię nie może być puste")
    private String firstName;
    @NotBlank(message = "Nazwisko nie może być puste")
    private String lastName;
    @Email
    private String email;
    @NotBlank
    //@PESEL
    private String pesel;
    private String address;
    @NotBlank
    private String position;
    private String description;
    @ManyToOne
    private Payment payment;

    public Employee(Long id, String firstName, String lastName, String email, String pesel, String address, String position, String description, Payment payment) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.pesel = pesel;
        this.address = address;
        this.position = position;
        this.description = description;
        this.payment = payment;
    }
}
