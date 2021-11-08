package com.maximo.esm.apimcr.api.model;

import com.maximo.esm.apimcr.domain.entity.Espaco;
import com.maximo.esm.apimcr.domain.entity.Unidade;
import com.maximo.esm.apimcr.domain.enums.StatusReserva;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Getter
@AllArgsConstructor
public class ReservaModel extends RepresentationModel implements Serializable {


    private Long id;

    @ManyToOne
    @Embedded
    private Unidade unidade;

    @OneToOne
    @Embedded
    private Espaco espaco;

    private OffsetDateTime dataInicio;
    private OffsetDateTime dataTermino;
    private String vistoriador;
}
