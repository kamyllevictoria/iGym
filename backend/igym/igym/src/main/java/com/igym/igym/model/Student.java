package com.igym.igym.model;

import com.igym.igym.controller.dto.UserDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;


@Entity
@Table(name = "aluno")
public class Student{

    @Id
    @Column(name = "usuario_id")
    private Long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false, unique = true)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "matricula")
    private Long registrationNumber;

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


    public Long getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(Long registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getMedications() {
        return medications;
    }

    public void setMedications(String medications) {
        this.medications = medications;
    }

    public String getSurgeries() {
        return surgeries;
    }

    public void setSurgeries(String surgeries) {
        this.surgeries = surgeries;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getHealthHistory() {
        return healthHistory;
    }

    public void setHealthHistory(String healthHistory) {
        this.healthHistory = healthHistory;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public UserDTO getUserDTO() {
        return null;
    }
}
