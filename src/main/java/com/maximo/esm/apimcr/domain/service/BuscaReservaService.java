package com.maximo.esm.apimcr.domain.service;

import com.maximo.esm.apimcr.domain.entity.Reserva;
import com.maximo.esm.apimcr.domain.exception.EntidadeNaoEncontrado;
import com.maximo.esm.apimcr.domain.repository.ReservaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BuscaReservaService {

    private ReservaRepository reservaRepository;

    public Reserva buscar(Long reservaid){
        return reservaRepository.findById(reservaid)
                .orElseThrow(()-> new EntidadeNaoEncontrado("Reserva não localizada."));
    }
}
