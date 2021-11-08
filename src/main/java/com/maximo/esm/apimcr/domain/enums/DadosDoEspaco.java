package com.maximo.esm.apimcr.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;

//@Embeddable
@AllArgsConstructor
@Getter
public enum DadosDoEspaco {

    JUVENIL("Juvenil",1), INFANTIL("Infantil",2),
    ADULTO("Adulto",3), GOURMER("Gourmer",4),
    PLAYG2("PlayG2",5), CINEMA("Cinema",6);

    @Column(name = "dados_do_espaco_nome")
    private final String nome;
    @Column(name = "dados_do_espaco_id")
    private final Integer id;
}
