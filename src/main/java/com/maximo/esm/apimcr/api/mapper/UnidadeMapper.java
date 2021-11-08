package com.maximo.esm.apimcr.api.mapper;

import com.maximo.esm.apimcr.api.controller.EncomendaController;
import com.maximo.esm.apimcr.api.controller.UnidadeController;
import com.maximo.esm.apimcr.api.model.UnidadeModel;
import com.maximo.esm.apimcr.api.model.input.EncomendaInput;
import com.maximo.esm.apimcr.api.model.input.UnidadeInput;
import com.maximo.esm.apimcr.domain.entity.Encomenda;
import com.maximo.esm.apimcr.domain.entity.Unidade;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@AllArgsConstructor
@Component
public class UnidadeMapper {

    private ModelMapper modelMapper;

    public UnidadeModel toModel (Unidade unidade){
        UnidadeModel unidadeModel = modelMapper.map(unidade,UnidadeModel.class);
        unidadeModel.add(linkTo(methodOn(UnidadeController.class)
                .buscar(unidade.getId())).withSelfRel());



        return unidadeModel;
    }

    public CollectionModel<UnidadeModel>toCollectionModel(List<Unidade>unidades){
        var unidadeModel = CollectionModel.of(unidades.stream()
                .map(this::toModel).collect(Collectors.toList()));
        unidadeModel.add(linkTo(methodOn(UnidadeController.class)
                .listarUnidades()).withRel("lista de Unidades"));

    /*    unidadeModel.add(linkTo(methodOn(UnidadeController.class)
                .listarUnidades()).withRel(IanaLinkRelations.COLLECTION));*/
        return unidadeModel;
    }

    public Unidade toEntity(UnidadeInput unidadeInput){
//        Encomenda encomenda = new Encomenda();
//        EncomendaInput encomendaInput = new EncomendaInput();
//
//        encomenda.add(linkTo(methodOn(EncomendaController.class)
//                .adicionar(encomendaInput)).withRel("Adicionar Encomenda"));

        return modelMapper.map(unidadeInput,Unidade.class);
    }
}
