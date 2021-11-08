package com.maximo.esm.apimcr.api.model.input;

import com.maximo.esm.apimcr.api.model.EspacoModel;
import com.maximo.esm.apimcr.domain.entity.Espaco;
import com.maximo.esm.apimcr.domain.entity.Unidade;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Getter
@Setter
public class ReservaInput {

    @ManyToOne
    @Embedded
    private UnidadeIdInput unidade;

    @OneToOne
    @Embedded
    private EspacoModel espaco;
}
