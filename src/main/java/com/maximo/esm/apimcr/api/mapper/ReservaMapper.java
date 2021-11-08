package com.maximo.esm.apimcr.api.mapper;

import com.maximo.esm.apimcr.api.controller.ReservaController;
import com.maximo.esm.apimcr.api.model.ReservaModel;
import com.maximo.esm.apimcr.api.model.input.ReservaInput;
import com.maximo.esm.apimcr.domain.entity.Reserva;
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
public class ReservaMapper {

    private ModelMapper modelMapper;

    public ReservaModel toModel(Reserva reserva){
        ReservaModel reservaModel = modelMapper.map(reserva,ReservaModel.class);

        reservaModel.add(linkTo(methodOn(ReservaController.class).listarReservas())
                .withRel("Reservas"));
        return reservaModel;
    }
/*    public List<ReservaModel>toCollectionModel(List<Reserva>reservas){
       return reservas.stream().map(this::toModel).collect(Collectors.toList());
    }*/

    public CollectionModel<ReservaModel>toCollectionModel(List<Reserva>reservas){
        var reservaModel = CollectionModel.of(reservas.stream()
                .map(this::toModel).collect(Collectors.toList()));

        reservaModel.add(linkTo(methodOn(ReservaController.class))
                .withRel("Lista de reservas"));
        return reservaModel;
    }

    public Reserva toEntity(ReservaInput reservaInput){
        var reserva = modelMapper.map(reservaInput,Reserva.class);


        return reserva;
    }

}
