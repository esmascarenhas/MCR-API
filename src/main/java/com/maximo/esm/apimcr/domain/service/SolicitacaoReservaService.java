package com.maximo.esm.apimcr.domain.service;

import com.maximo.esm.apimcr.domain.entity.Espaco;
import com.maximo.esm.apimcr.domain.entity.Reserva;
import com.maximo.esm.apimcr.domain.entity.Unidade;
import com.maximo.esm.apimcr.domain.enums.StatusReserva;
import com.maximo.esm.apimcr.domain.exception.NegocioException;
import com.maximo.esm.apimcr.domain.repository.ReservaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class SolicitacaoReservaService {

    private ReservaRepository reservaRepository;
    private UnidadeService unidadeService;
    private Espaco espaco;

    public Reserva solicitarReserva(Reserva reserva){
       boolean espacoreservado = StatusReserva.RESERVADO.equals(espaco.getStatus());
        if(espacoreservado){
            throw new NegocioException("Espaço já reservado");
        }

        Unidade unidade = unidadeService.buscar(reserva.getUnidade().getId());

        reserva.setUnidade(unidade);
        reserva.getEspaco().setStatus(StatusReserva.RESERVADO);
        reserva.setDataInicio(OffsetDateTime.now());

        return reservaRepository.save(reserva);
    }
}
