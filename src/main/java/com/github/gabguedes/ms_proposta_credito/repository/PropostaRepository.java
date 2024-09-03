package com.github.gabguedes.ms_proposta_credito.repository;

import com.github.gabguedes.ms_proposta_credito.model.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropostaRepository extends JpaRepository<Proposta, Long> {
}
