package com.maximo.esm.apimcr.api.model;

import com.maximo.esm.apimcr.domain.entity.Unidade;
import com.maximo.esm.apimcr.domain.enums.StatusEncomenda;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import java.time.OffsetDateTime;
import java.util.Collection;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Relation(collectionRelation="Relação de Encomendas")
public class EncomendaModel extends RepresentationModel<EncomendaModel> {

    private Long id;
    private UnidadeResumoModel unidadeResumoModel;
    private StatusEncomenda statusEncomenda;
    private OffsetDateTime entradaEncomenda;
    private OffsetDateTime baixaEncomenda;
    private String notaFiscal;
}
