package com.maximo.esm.apimcr.domain.service;

import com.maximo.esm.apimcr.domain.entity.OcorrenciaReserva;
import com.maximo.esm.apimcr.domain.entity.Reserva;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaReservaService {

    private BuscaReservaService buscaReservaService;

    public OcorrenciaReserva adicionarOcocrrenciaReserva(Long reservaid, String descricao){
        Reserva reserva = buscaReservaService.buscar(reservaid);
        return reserva.adicionarOcorrenciaReserva(descricao);
    }
}
