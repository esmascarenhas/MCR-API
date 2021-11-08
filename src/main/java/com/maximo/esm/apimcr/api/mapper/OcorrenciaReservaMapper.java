package com.maximo.esm.apimcr.api.mapper;

import com.maximo.esm.apimcr.api.controller.OcorrenciaReservaController;
import com.maximo.esm.apimcr.api.model.OcorrenciaReservaModel;
import com.maximo.esm.apimcr.domain.entity.OcorrenciaReserva;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
@AllArgsConstructor
public class OcorrenciaReservaMapper {

    private ModelMapper modelMapper;

    public OcorrenciaReservaModel toModel(OcorrenciaReserva ocorrenciaReserva){
        OcorrenciaReservaModel ocorrencia = modelMapper.map(ocorrenciaReserva,OcorrenciaReservaModel.class);
        ocorrencia.add(linkTo(methodOn(OcorrenciaReservaController.class))
                .withRel("Relatório de ocorrências nas reservas"));
        return ocorrencia;
    }
    public List<OcorrenciaReservaModel>toCollectionModel(List<OcorrenciaReserva>ocorrenciaReservas){
        return ocorrenciaReservas.stream().map(this::toModel)
                .collect(Collectors.toList());
    }
}
