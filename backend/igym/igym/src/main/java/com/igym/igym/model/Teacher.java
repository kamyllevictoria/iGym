package com.igym.igym.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "professor")
public class Teacher extends User {
    @Id
    @Column(name = "cref", nullable = false, unique = true, length = 7)
    private String cref;

    public String getCref() {
        return cref;
    }

    public void setCref(String cref) {
        this.cref = cref;
    }
}