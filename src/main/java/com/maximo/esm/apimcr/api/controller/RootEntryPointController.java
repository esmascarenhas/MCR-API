package com.maximo.esm.apimcr.api.controller;

import com.maximo.esm.apimcr.api.model.RootEntryPointModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class RootEntryPointController {

    @GetMapping
    public RootEntryPointModel unidades(){
        var unidades = new RootEntryPointModel();
        unidades.add(linkTo(methodOn(UnidadeController.class)
                .listarUnidades()).withRel("Relação de Unidades"));
        return unidades;
    }
/*    @GetMapping
    public RootEntryPointModel reservas(){
        var reservas = new RootEntryPointModel();
        reservas.add(linkTo(methodOn(ReservaController.class)
                .listarReservas()).withRel("Lista de Reservas"));
        return reservas;
    }*/
 /*   @GetMapping
    public RootEntryPointModel encomendas(){
        var encomenda = new RootEntryPointModel();
        encomenda.add(linkTo(methodOn(EncomendaController.class)
                .listarEncomendas()).withRel("Lista de Encomendas"));
        return encomenda;
    }*/
/*    @GetMapping
    public RootEntryPointModel ocorrenciasReservas(){
        var ocorrenciaReserva = new RootEntryPointModel();
        ocorrenciaReserva.add(linkTo(methodOn(OcorrenciaReservaController.class))
                .withRel("Ocorrências de Reservas"));
        return ocorrenciaReserva;
    }*/
/*    @GetMapping
    public RootEntryPointModel ocorrenciasEncomendas(){
        var ocorrenciaEncomenda = new RootEntryPointModel();
        ocorrenciaEncomenda.add(linkTo(methodOn(OcorrenciaEncomendaController.class))
                .withRel("Ocorrências de Encomenda"));
        return ocorrenciaEncomenda;
    }*/


}
