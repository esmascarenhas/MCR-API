package com.maximo.esm.apimcr.api.model.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
public class UnidadeIdInput {

    @NotNull
    private Long id;

    public UnidadeIdInput() {
    }

    public Long getid(){
        return id;
    }


}
