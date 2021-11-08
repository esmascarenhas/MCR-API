package com.maximo.esm.apimcr.api.controller;

import com.maximo.esm.apimcr.api.mapper.OcorrenciaReservaMapper;
import com.maximo.esm.apimcr.api.model.OcorrenciaEncomendaModel;
import com.maximo.esm.apimcr.api.model.OcorrenciaReservaModel;
import com.maximo.esm.apimcr.api.model.input.OcorrenciaReservaInput;
import com.maximo.esm.apimcr.domain.entity.OcorrenciaReserva;
import com.maximo.esm.apimcr.domain.entity.Reserva;
import com.maximo.esm.apimcr.domain.service.BuscaReservaService;
import com.maximo.esm.apimcr.domain.service.RegistroOcorrenciaReservaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/ocorrenciaReserva")
public class OcorrenciaReservaController {

    private OcorrenciaReservaMapper ocorrenciaReservaMapper;
    private RegistroOcorrenciaReservaService registroOcorrenciaReservaService;
    private BuscaReservaService buscaReservaService;

    @GetMapping
    public List<OcorrenciaReservaModel>listar(@PathVariable Long reservaid){
        Reserva reserva = buscaReservaService.buscar(reservaid);
        return ocorrenciaReservaMapper.toCollectionModel(reserva.getOcorrenciaReservas());
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaReservaModel registrar(@PathVariable Long reservaid,
                                              @Valid @PathVariable OcorrenciaReservaInput ocorrenciaReservaInput){
        OcorrenciaReserva ocorrenciaRegistrada = registroOcorrenciaReservaService
                .adicionarOcocrrenciaReserva(reservaid,ocorrenciaReservaInput.getDescricao());
        return ocorrenciaReservaMapper.toModel(ocorrenciaRegistrada);
    }
}
