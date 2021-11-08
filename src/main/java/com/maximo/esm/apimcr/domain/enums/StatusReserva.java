package com.maximo.esm.apimcr.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@AllArgsConstructor
@Getter
@Embeddable
public enum StatusReserva {
    DISPONIVEL("Disponivel"),RESERVADO("Reservado"),SUSPENSO("Suspenso"),MANUTENCAO("Manutencao");

    public final String status;
}
