package com.igym.igym.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Entity
@Data
public class Usuario {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Email
    @Column(name = "email", length = 200, nullable = false)
    private String email;

    @Column(name = "password", length = 10, nullable = false)
    private String password;

    @Column(name = "phoneNumber", length = 11, nullable = false)
    private Integer phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", length = 10, nullable = false)
    private Gender gender;

    @Column(name = "birthDate", nullable = false)
    private LocalDate birthDate;

    @CPF
    @Column(name = "CPF", nullable = false, unique = true)
    private String CPF;

    @Column(name = "age", nullable = false)
    private Integer age;
}
