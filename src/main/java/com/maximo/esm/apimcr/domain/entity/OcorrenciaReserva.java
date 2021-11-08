package com.maximo.esm.apimcr.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "ocorrencia_reserva")
public class OcorrenciaReserva {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne
    private Reserva reserva;

    @ManyToOne
    private Unidade unidade;

    private String descricao;
    private OffsetDateTime dataRegistro;
}
