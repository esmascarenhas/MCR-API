package com.maximo.esm.apimcr.domain.service;

import com.maximo.esm.apimcr.domain.entity.Encomenda;
import com.maximo.esm.apimcr.domain.entity.OcorrenciaEncomenda;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaEncomendaService {

    private BuscaEncomendaService buscaEncomendaService;

    public OcorrenciaEncomenda registrar(Long encomendaid, String descricao){
        Encomenda encomenda = buscaEncomendaService.buscar(encomendaid);
        return encomenda.adicionarOcorrenciaEncomenda((descricao));
    }
}
