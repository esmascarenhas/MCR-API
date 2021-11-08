package com.maximo.esm.apimcr.api.model;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

@Relation(collectionRelation = "Relação de Unidades")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UnidadeModel extends RepresentationModel<UnidadeModel>implements Serializable {

    private Long id;
    private String proprietario;
    private String contato;
    private String email;
    private Long unidade;
    private String torre;

}
