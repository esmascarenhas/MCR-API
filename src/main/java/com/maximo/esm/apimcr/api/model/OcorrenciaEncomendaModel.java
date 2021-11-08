package com.maximo.esm.apimcr.api.model;

import com.maximo.esm.apimcr.domain.entity.Encomenda;
import com.maximo.esm.apimcr.domain.entity.Unidade;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import javax.persistence.Access;
import javax.persistence.Embedded;
import javax.persistence.ManyToOne;
import java.time.OffsetDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Relation(collectionRelation = "Ocorrências nas Encomendas")
@Data
public class OcorrenciaEncomendaModel extends RepresentationModel<OcorrenciaEncomendaModel> {

    private Long id;


    private Unidade unidade;

    private Encomenda encomenda;

    private String descricao;
    private OffsetDateTime dataRegistro;
}
