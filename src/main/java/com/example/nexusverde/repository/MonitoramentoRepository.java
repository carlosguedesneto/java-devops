package com.example.nexusverde.repository;

import com.example.nexusverde.entity.Monitoramento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitoramentoRepository extends JpaRepository<Monitoramento, Long> {
}