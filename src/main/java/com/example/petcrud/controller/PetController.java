package com.example.petcrud.controller;

import com.example.petcrud.entity.Pet;
import com.example.petcrud.service.PetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;

    // GET /api/pets
    @GetMapping
    public ResponseEntity<List<Pet>> listarTodos() {
        return ResponseEntity.ok(petService.listarTodos());
    }

    // GET /api/pets/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Pet> buscarPorId(@PathVariable Long id) {
        return petService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET /api/pets/codigo/{codigo}
    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<Pet> buscarPorCodigo(@PathVariable String codigo) {
        return petService.buscarPorCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET /api/pets/especie?especie=Cachorro
    @GetMapping("/especie")
    public ResponseEntity<List<Pet>> buscarPorEspecie(@RequestParam String especie) {
        return ResponseEntity.ok(petService.buscarPorEspecie(especie));
    }

    // GET /api/pets/buscar?nome=Rex
    @GetMapping("/buscar")
    public ResponseEntity<List<Pet>> buscarPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(petService.buscarPorNome(nome));
    }

    // GET /api/pets/raca?raca=Labrador
    @GetMapping("/raca")
    public ResponseEntity<List<Pet>> buscarPorRaca(@RequestParam String raca) {
        return ResponseEntity.ok(petService.buscarPorRaca(raca));
    }

    // POST /api/pets
    @PostMapping
    public ResponseEntity<Pet> criar(@Valid @RequestBody Pet pet) {
        Pet petCriado = petService.criar(pet);
        return ResponseEntity.status(HttpStatus.CREATED).body(petCriado);
    }

    // PUT /api/pets/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Pet> atualizar(@PathVariable Long id, @Valid @RequestBody Pet pet) {
        return petService.atualizar(id, pet)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/pets/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (petService.deletar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
