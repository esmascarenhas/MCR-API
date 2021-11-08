package com.maximo.esm.apimcr.domain.service;

import com.maximo.esm.apimcr.domain.entity.Reserva;
import com.maximo.esm.apimcr.domain.exception.EntidadeNaoEncontrado;
import com.maximo.esm.apimcr.domain.repository.ReservaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FinalizarReservaService {

    private ReservaRepository reservaRepository;
    private BuscaReservaService buscaReservaService;

    public ResponseEntity<Void> baixarReserva( Long reservaid){
        Reserva reserva = buscaReservaService.buscar(reservaid);

        reserva.baixarReserva();
        reservaRepository.save(reserva);
        return ResponseEntity.noContent().build();
    }


}
