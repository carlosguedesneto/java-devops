package com.example.petcrud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "codigo_animal", nullable = false)
    private String codigoAnimal;

    @Column(nullable = false)
    private String especie;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String raca;

    private Integer idade;
}