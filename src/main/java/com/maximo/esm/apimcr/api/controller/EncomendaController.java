package com.maximo.esm.apimcr.api.controller;

import com.maximo.esm.apimcr.api.mapper.EncomendaMapper;
import com.maximo.esm.apimcr.api.model.EncomendaModel;
import com.maximo.esm.apimcr.api.model.input.EncomendaInput;
import com.maximo.esm.apimcr.domain.entity.Encomenda;
import com.maximo.esm.apimcr.domain.repository.EncomendaRespository;
import com.maximo.esm.apimcr.domain.service.BaixaEncomendaService;
import com.maximo.esm.apimcr.domain.service.BuscaEncomendaService;
import com.maximo.esm.apimcr.domain.service.AdicionarEncomendaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1/encomendas")
@Api("MCR API REST - Controle de Encomendas")
@CrossOrigin("*")
public class EncomendaController {

    private EncomendaRespository encomendaRespository;
    private AdicionarEncomendaService adicionarEncomendaService;
    private EncomendaMapper encomendaMapper;
    private BaixaEncomendaService baixaEncomendaService;
    private BuscaEncomendaService buscaEncomendaService;


    @GetMapping
    @ApiOperation(value = "Retorna uma lista de Encomendas")
    public CollectionModel<EncomendaModel> listarEncomendas(){
        return encomendaMapper.toCollectionModel(encomendaRespository.findAll());
    }
    @GetMapping("/{encomendaid}")
    @ApiOperation(value = "Retorna uma Encomenda específica")
    public ResponseEntity<Encomenda> buscar(@PathVariable Long encomendaid){
        return encomendaRespository.findById(encomendaid)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Adiciona uma Encomenda")
    public EncomendaModel adicionar(@Valid @RequestBody EncomendaInput encomendaInput){
    Encomenda novaEncomenda = encomendaMapper.toEntity(encomendaInput);
    Encomenda encomendaCadastrada = adicionarEncomendaService.adicionarEncomenda(novaEncomenda);
    return encomendaMapper.toModel(encomendaCadastrada);
    }
    @PutMapping({"/{encomendaid"})
    @ApiOperation(value = "Faz a baixa de uma Encomenda")
    public ResponseEntity<Void> baixarEncomenda(Long encomendaid){
        baixaEncomendaService.baixarEncomenda(encomendaid);
        return ResponseEntity.noContent().build();
    }


}
