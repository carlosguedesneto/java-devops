package com.example.nexusverde.service;

import com.example.nexusverde.entity.Alerta;
import com.example.nexusverde.repository.AlertaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlertaService {

    private final AlertaRepository repository;

    public AlertaService(AlertaRepository repository) {
        this.repository = repository;
    }

    public List<Alerta> listarTodos() {
        return repository.findAll();
    }

    public Optional<Alerta> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Alerta criar(Alerta alerta) {
        return repository.save(alerta);
    }

    public Optional<Alerta> atualizar(Long id, Alerta dados) {
        return repository.findById(id).map(alerta -> {
            alerta.setTipoAlerta(dados.getTipoAlerta());
            alerta.setNivelRisco(dados.getNivelRisco());
            alerta.setDescricao(dados.getDescricao());
            alerta.setDataHora(dados.getDataHora());
            alerta.setMonitoramento(dados.getMonitoramento());
            return repository.save(alerta);
        });
    }

    public boolean deletar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}