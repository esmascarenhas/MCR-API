package com.maximo.esm.apimcr.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "ocorrencia_encomenda")
public class OcorrenciaEncomenda {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Long id;


    @ManyToOne
    private Unidade unidade;


    @ManyToOne
    private Encomenda encomenda;

    private String descricao;
    private OffsetDateTime dataRegistro;
}
