package com.maximo.esm.apimcr.domain.service;

import com.maximo.esm.apimcr.domain.entity.Encomenda;
import com.maximo.esm.apimcr.domain.repository.EncomendaRespository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BaixaEncomendaService {

    private EncomendaRespository encomendaRespository;
    private BuscaEncomendaService buscaEncomendaService;

    public ResponseEntity<Void>baixarEncomenda(Long encomendaid){
        Encomenda encomenda = buscaEncomendaService.buscar(encomendaid);
        encomenda.baixarEncomenda();
        encomendaRespository.save(encomenda);
        return ResponseEntity.noContent().build();
    }
}
