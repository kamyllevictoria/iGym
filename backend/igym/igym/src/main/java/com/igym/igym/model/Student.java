package com.igym.igym.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Setter
@Getter
@Entity
@Table(name = "aluno")
public class Student extends User {

    @Column(length = 10, name = "matricula")
    private String registrationNumber;

    @Column(name = "altura", nullable = false, length = 100)
    private Double height;

    @Column(name = "peso")
    private Double weight;

    @Column(name = "medicamentos", nullable = false, length = 100)
    private String medications;

    @Column(name = "cirurgias", nullable = false)
    private String surgeries;

    @Enumerated(EnumType.STRING)
    @Column(name = "metodo_pagamento")
    private Payment payment;

    @Column(name = "historico_de_saude", nullable = false)
    private String healthHistory;

    @Column(name = "pressao_arterial", nullable = false)
    private String bloodPressure;

    @PrePersist
    public void generateRegistrationNumber() {
        if (this.registrationNumber == null) {
            this.registrationNumber = generateRandomRegistration();
        }
    }

    private String generateRandomRegistration() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

}
