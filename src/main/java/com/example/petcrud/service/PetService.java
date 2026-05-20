package com.example.petcrud.service;

import com.example.petcrud.model.Pet;
import com.example.petcrud.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;

    public List<Pet> listarTodos() {
        return petRepository.findAll();
    }

    public Optional<Pet> buscarPorId(Long id) {
        return petRepository.findById(id);
    }

    public Optional<Pet> buscarPorCodigo(String codigoAnimal) {
        return petRepository.findByCodigoAnimal(codigoAnimal);
    }

    public List<Pet> buscarPorEspecie(String especie) {
        return petRepository.findByEspecieIgnoreCase(especie);
    }

    public List<Pet> buscarPorNome(String nome) {
        return petRepository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Pet> buscarPorRaca(String raca) {
        return petRepository.findByRacaIgnoreCase(raca);
    }

    public Pet criar(Pet pet) {
        return petRepository.save(pet);
    }

    public Optional<Pet> atualizar(Long id, Pet petAtualizado) {
        return petRepository.findById(id).map(petExistente -> {
            petExistente.setCodigoAnimal(petAtualizado.getCodigoAnimal());
            petExistente.setEspecie(petAtualizado.getEspecie());
            petExistente.setNome(petAtualizado.getNome());
            petExistente.setRaca(petAtualizado.getRaca());
            petExistente.setIdade(petAtualizado.getIdade());
            return petRepository.save(petExistente);
        });
    }

    public boolean deletar(Long id) {
        if (petRepository.existsById(id)) {
            petRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
