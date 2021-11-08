package com.maximo.esm.apimcr.domain.repository;

import com.maximo.esm.apimcr.domain.entity.Encomenda;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EncomendaRespository extends JpaRepository<Encomenda,Long> {

    Optional<Encomenda>findByNotaFiscal(String notaFiscal);
}
