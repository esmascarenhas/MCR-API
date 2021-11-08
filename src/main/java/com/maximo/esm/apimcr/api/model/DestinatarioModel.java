package com.maximo.esm.apimcr.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class DestinatarioModel {


    private String nomeDestinatario;

    private String rgDestinatario;
}
