package com.maximo.esm.apimcr.api.controller;

import com.maximo.esm.apimcr.api.mapper.ReservaMapper;
import com.maximo.esm.apimcr.api.model.ReservaModel;
import com.maximo.esm.apimcr.api.model.input.ReservaInput;
import com.maximo.esm.apimcr.domain.entity.Reserva;
import com.maximo.esm.apimcr.domain.repository.ReservaRepository;
import com.maximo.esm.apimcr.domain.service.FinalizarReservaService;
import com.maximo.esm.apimcr.domain.service.BuscaReservaService;
import com.maximo.esm.apimcr.domain.service.SolicitacaoReservaService;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/reservas")
public class ReservaController {

    private ReservaRepository reservaRepository;
    private ReservaMapper reservaMapper;
    private FinalizarReservaService finalizarReservaService;
    private BuscaReservaService buscaReservaService;
    private SolicitacaoReservaService solicitacaoReservaService;

    @GetMapping
    public CollectionModel<ReservaModel>listarReservas (){
        return reservaMapper.toCollectionModel(reservaRepository.findAll());
    }
    @GetMapping("/{reservaid}")
    public ResponseEntity<ReservaModel>buscarReserva(@Valid @PathVariable Long reservaid){
        return reservaRepository.findById(reservaid)
                .map(reserva -> ResponseEntity.ok(reservaMapper.toModel(reserva)))
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReservaModel AdicionarReserva(@Valid @RequestBody ReservaInput reservaInput){
        Reserva novaReserva = reservaMapper.toEntity(reservaInput);
        Reserva reservaAdicionada = solicitacaoReservaService.solicitarReserva(novaReserva);
        return reservaMapper.toModel(reservaAdicionada);
    }
    @PutMapping("/{reservaid}")
    public ResponseEntity<Void>finalizarReserva(@PathVariable Long reservaid){
        finalizarReservaService.baixarReserva(reservaid);
        return ResponseEntity.noContent().build();
    }

}
