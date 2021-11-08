package com.maximo.esm.apimcr.api.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
public class UnidadeResumoModel extends RepresentationModel<UnidadeResumoModel> {

    private Long id;
    private String proprietario;
    private Long unidade;
    private String torre;

}
