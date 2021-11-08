package com.maximo.esm.apimcr.domain.entity;

import com.maximo.esm.apimcr.domain.enums.DadosDoEspaco;
import com.maximo.esm.apimcr.domain.enums.StatusReserva;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Getter
@Setter
@Component
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Espaco {


    @Id
    @Embedded
    @NotBlank
    //@Enumerated(EnumType.STRING )
    private DadosDoEspaco dadosDoEspaco;


    @Embedded
    @NotBlank
    @Enumerated(EnumType.STRING )
    private StatusReserva status;
}
