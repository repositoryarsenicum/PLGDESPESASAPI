package br.com.plataformalancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.plataformalancamento.model.DespesaModel;

public interface DespesaRepository extends JpaRepository<DespesaModel, Long> { }
