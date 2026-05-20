package com.example.petcrud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "pets")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O código do animal é obrigatório")
    @Size(min = 2, max = 20, message = "O código deve ter entre 2 e 20 caracteres")
    @Column(nullable = false, unique = true)
    private String codigoAnimal;

    @NotBlank(message = "A espécie é obrigatória")
    @Size(min = 2, max = 50, message = "A espécie deve ter entre 2 e 50 caracteres")
    @Column(nullable = false)
    private String especie;

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres")
    @Column(nullable = false)
    private String nome;

    @NotBlank(message = "A raça é obrigatória")
    @Size(min = 2, max = 100, message = "A raça deve ter entre 2 e 100 caracteres")
    @Column(nullable = false)
    private String raca;

    @NotNull(message = "A idade é obrigatória")
    @Min(value = 0, message = "A idade não pode ser negativa")
    @Max(value = 100, message = "A idade máxima é 100 anos")
    @Column(nullable = false)
    private Integer idade;
}
