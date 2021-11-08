package com.maximo.esm.apimcr.api.model;

import com.maximo.esm.apimcr.domain.enums.DadosDoEspaco;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EspacoModel {

    private Long id;
    private DadosDoEspaco dadosDoEspaco;

}
