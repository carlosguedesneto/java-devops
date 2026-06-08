package com.example.nexusverde.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "monitoramentos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Monitoramento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String regiao;

    @Column(nullable = false)
    private String satelite;

    @Column(name = "status_vegetacao", nullable = false)
    private String statusVegetacao;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    @PrePersist
    protected void onCreate() {
        if (dataHora == null) {
            dataHora = LocalDateTime.now();
        }
    }
}