package com.example.petcrud.repository;


import com.example.petcrud.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    java.util.Optional<Pet> findByCodigoAnimal(String codigoAnimal);

    List<Pet> findByEspecieIgnoreCase(String especie);

    List<Pet> findByNomeContainingIgnoreCase(String nome);

    List<Pet> findByRacaIgnoreCase(String raca);
}
