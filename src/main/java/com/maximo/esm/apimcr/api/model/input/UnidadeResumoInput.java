package com.maximo.esm.apimcr.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UnidadeResumoInput {

    @NotBlank
    @Size(min = 2, max = 80)
    private String proprietario;

    @NotNull
    private Long unidade;

    @NotBlank
    @Size(min = 2, max = 50)
    private String torre;
}
