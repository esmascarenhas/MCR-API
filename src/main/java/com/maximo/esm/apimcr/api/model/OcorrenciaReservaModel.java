package com.maximo.esm.apimcr.api.model;

import com.maximo.esm.apimcr.domain.entity.Reserva;
import com.maximo.esm.apimcr.domain.entity.Unidade;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import javax.persistence.ManyToOne;
import java.time.OffsetDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Relation(collectionRelation = "Ocorrencias nas reservas")
public class OcorrenciaReservaModel extends RepresentationModel<OcorrenciaReservaModel> {

    private Long id;

    @ManyToOne
    private Reserva reserva;

    @ManyToOne
    private Unidade unidade;

    private String descricao;
    private OffsetDateTime dataRegistro;
}
