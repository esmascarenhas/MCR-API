package com.maximo.esm.apimcr.api.mapper;

import com.maximo.esm.apimcr.api.controller.EncomendaController;
import com.maximo.esm.apimcr.api.model.EncomendaModel;
import com.maximo.esm.apimcr.api.model.input.EncomendaInput;
import com.maximo.esm.apimcr.domain.entity.Encomenda;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
@AllArgsConstructor
public class EncomendaMapper {

    private ModelMapper modelMapper;

    public EncomendaModel toModel(Encomenda encomenda){
        var encomendaModel = modelMapper
                .map(encomenda,EncomendaModel.class);

        encomendaModel.add(linkTo(methodOn(EncomendaController.class)
                .buscar(encomenda.getId())).withSelfRel());

        encomendaModel.add(linkTo(methodOn(EncomendaController.class)
        .buscar(encomenda.getUnidade().getId())).withSelfRel());

        encomendaModel.add(linkTo(methodOn(EncomendaController.class)
                .listarEncomendas()).withRel("Lista de Encomendas"));

        if(encomenda.podeserbaixado()){
            encomendaModel.add(linkTo(methodOn(EncomendaController.class)
                    .baixarEncomenda(encomenda.getId())).withRel("Baixar Encomenda"));
        }
        return encomendaModel;
    }

  /*  public List<EncomendaModel> toCollectionModel(List<Encomenda>encomendas){
        return encomendas.stream().map(this::toModel).collect(Collectors.toList());
    }*/

    public CollectionModel<EncomendaModel>toCollectionModel(List<Encomenda>encomendas){
        var encomendaModel =
                CollectionModel.of(encomendas.stream()
                .map(this::toModel).collect(Collectors.toList()));
        encomendaModel.add(linkTo(methodOn(EncomendaController.class)
                .listarEncomendas()).withSelfRel());
    return encomendaModel;
    }

    public Encomenda toEntity(EncomendaInput encomendaInput){
        var encomenda = modelMapper.map(encomendaInput,Encomenda.class);

        encomenda.add(linkTo(methodOn(EncomendaController.class)
                .adicionar(encomendaInput)).withRel("Adicionar Encomenda"));

        return encomenda;
    }


}
