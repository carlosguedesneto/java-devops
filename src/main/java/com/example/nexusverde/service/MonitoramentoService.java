package com.example.nexusverde.service;

import com.example.nexusverde.entity.Monitoramento;
import com.example.nexusverde.repository.MonitoramentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonitoramentoService {

    private final MonitoramentoRepository repository;

    public MonitoramentoService(MonitoramentoRepository repository) {
        this.repository = repository;
    }

    public List<Monitoramento> listarTodos() {
        return repository.findAll();
    }

    public Optional<Monitoramento> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Monitoramento criar(Monitoramento monitoramento) {
        return repository.save(monitoramento);
    }

    public Optional<Monitoramento> atualizar(Long id, Monitoramento dados) {
        return repository.findById(id).map(monitoramento -> {
            monitoramento.setRegiao(dados.getRegiao());
            monitoramento.setSatelite(dados.getSatelite());
            monitoramento.setStatusVegetacao(dados.getStatusVegetacao());
            monitoramento.setDataHora(dados.getDataHora());
            return repository.save(monitoramento);
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
