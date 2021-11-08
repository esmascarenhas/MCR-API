package com.maximo.esm.apimcr.domain.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Unidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank
    @Size(min = 2, max = 80)
    private String proprietario;

    @NotBlank
    @Size(min = 2, max = 20)
    private String contato;

   @NotBlank
    @Size(min = 2, max = 120)
   @Email
    private String email;

   @NotNull
    private Long unidade;

    @NotBlank
    @Size(min = 2, max = 50)
    private String torre;


}
