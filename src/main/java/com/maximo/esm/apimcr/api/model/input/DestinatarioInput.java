package com.maximo.esm.apimcr.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class DestinatarioInput {

    @NotBlank
    @Column(name = "destinatario_nome")
    private String nome;


    @NotBlank
    @Column(name = "destinatario_rg")
    private String rg;
}
