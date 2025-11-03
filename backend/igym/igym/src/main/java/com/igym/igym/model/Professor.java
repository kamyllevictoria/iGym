package com.igym.igym.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Professor extends Usuario {
    @Id
    @Column(name = "cref", nullable = false, unique = true, length = 7)
    private String cref;
}