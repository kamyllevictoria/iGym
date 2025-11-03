package com.igym.igym.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Random;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Aluno extends Usuario {

    @Id
    @Column(length = 10, name = "matricula")
    private String registrationNumber;

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

    @Column(name = "altura", nullable = false, length = 100)
    private Double height;

    @Column(name = "peso",length = 100)
    private Double weight;

    @Column(name = "medicamentos", nullable = false, length = 100)
    private String medications;

    @Column(name = "cirurgias", nullable = false)
    private String surgeries;

    @Column(name = "metodoPagamento", nullable = false)
    private Payment payment;

    @Column(name = "historicoDeSaude", nullable = false)
    private String healthHistory;

    @Column(name = "tipoArterial", nullable = false)
    private String bloodPressure;

}
