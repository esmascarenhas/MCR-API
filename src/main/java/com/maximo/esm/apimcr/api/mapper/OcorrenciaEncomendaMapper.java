package com.maximo.esm.apimcr.api.mapper;

import com.maximo.esm.apimcr.api.controller.OcorrenciaEncomendaController;
import com.maximo.esm.apimcr.api.model.OcorrenciaEncomendaModel;
import com.maximo.esm.apimcr.domain.entity.OcorrenciaEncomenda;
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
public class OcorrenciaEncomendaMapper {

        private ModelMapper modelMapper;

        public OcorrenciaEncomendaModel toModel(OcorrenciaEncomenda ocorrenciaEncomenda){
            OcorrenciaEncomendaModel ocorrencia = modelMapper
                    .map(ocorrenciaEncomenda,OcorrenciaEncomendaModel.class);
            ocorrencia.add(linkTo(methodOn(OcorrenciaEncomendaController.class))
                    .withRel("Relatório de Ocorrências nas Encomendas"));
            return ocorrencia;
        }

        public List<OcorrenciaEncomendaModel>toCollectionModel(List<OcorrenciaEncomenda>ocorrenciaEncomendas){
            return ocorrenciaEncomendas.stream().map(this::toModel)
                    .collect(Collectors.toList());
        }

}
