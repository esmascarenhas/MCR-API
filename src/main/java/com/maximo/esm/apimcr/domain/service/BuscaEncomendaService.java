package com.maximo.esm.apimcr.domain.service;

import com.maximo.esm.apimcr.domain.entity.Encomenda;
import com.maximo.esm.apimcr.domain.exception.EntidadeNaoEncontrado;
import com.maximo.esm.apimcr.domain.repository.EncomendaRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BuscaEncomendaService {

    private EncomendaRespository encomendaRespository;

    public Encomenda buscar (Long encomendaid) {
        return encomendaRespository.findById(encomendaid)
                .orElseThrow(()-> new EntidadeNaoEncontrado("Encomenda não encontrada"));
    }
}
