package com.maximo.esm.apimcr.api.controller;

import com.maximo.esm.apimcr.api.mapper.OcorrenciaEncomendaMapper;
import com.maximo.esm.apimcr.api.model.OcorrenciaEncomendaModel;
import com.maximo.esm.apimcr.api.model.input.OcorrenciaEncomendaInput;
import com.maximo.esm.apimcr.domain.entity.Encomenda;
import com.maximo.esm.apimcr.domain.entity.OcorrenciaEncomenda;
import com.maximo.esm.apimcr.domain.service.BuscaEncomendaService;
import com.maximo.esm.apimcr.domain.service.RegistroOcorrenciaEncomendaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(value = "/api/v1/ocorrenciaEncomenda")
@RestController
@AllArgsConstructor
@Api("MCR API REST - Controle das Ocorências de Encomendas")
@CrossOrigin("*")
public class OcorrenciaEncomendaController {

    private BuscaEncomendaService buscaEncomendaService;
    private RegistroOcorrenciaEncomendaService registroOcorrenciaEncomendaService;
    private OcorrenciaEncomendaMapper ocorrenciaEncomendaMapper;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Adiciona uma ocorrência de Encomendas")
    public OcorrenciaEncomendaModel Registrar(@PathVariable Long encomendaid,
                                         @Valid @PathVariable OcorrenciaEncomendaInput ocorrenciaEncomendaInput){
        OcorrenciaEncomenda ocorrenciaRegistrada = registroOcorrenciaEncomendaService
                .registrar(encomendaid,ocorrenciaEncomendaInput.getDescricao());
        return ocorrenciaEncomendaMapper.toModel(ocorrenciaRegistrada);
    }
    @GetMapping
    @ApiOperation(value = "lista ocorrências de Encomendas")
    public List<OcorrenciaEncomendaModel>listar(@PathVariable Long encomendaid){
        Encomenda encomenda = buscaEncomendaService.buscar(encomendaid);
        return ocorrenciaEncomendaMapper.toCollectionModel(encomenda.getOcorrenciaEncomendas());

    }
}
