package com.maximo.esm.apimcr.api.model.input;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class EncomendaInput {

   @NotNull
   @Valid
   private UnidadeIdInput unidade;

    @NotNull
    @Valid
    private DestinatarioInput destinatario;

    @NotNull
    private String nota;




}
