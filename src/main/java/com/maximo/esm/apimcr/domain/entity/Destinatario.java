package com.maximo.esm.apimcr.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Embeddable
public class Destinatario {


    @NotBlank
    @Column(name = "destinatario_nome")
    private String nome;


    @NotBlank
    @Column(name = "destinatario_rg")
    private String rg;
}
