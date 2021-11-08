package com.maximo.esm.apimcr.domain.entity;

import com.maximo.esm.apimcr.domain.enums.StatusReserva;
import com.maximo.esm.apimcr.domain.exception.NegocioException;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @ManyToOne
    private Unidade unidade;

    @NotBlank
    @OneToOne
    private Espaco espaco;

    private OffsetDateTime dataInicio;
    private OffsetDateTime dataTermino;

    @NotBlank
    @Size(min = 2,max = 60)
    private String vistoriador;

    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL)
    private List<OcorrenciaReserva> ocorrenciaReservas = new ArrayList<>();


    public OcorrenciaReserva adicionarOcorrenciaReserva(String descricao){
        OcorrenciaReserva ocorrencia = new OcorrenciaReserva();

        ocorrencia.setDescricao(descricao);
        ocorrencia.setDataRegistro (OffsetDateTime.now());
        ocorrencia.setReserva(this);

        return ocorrencia;
    }

    public void baixarReserva (){
        if(naopodeserbaixado()){
            throw new NegocioException("Reserva não pode ser baixada.");
        }
            getEspaco().setStatus(StatusReserva.DISPONIVEL);
            setDataTermino(OffsetDateTime.now());
    }
    public boolean naopodeserbaixado(){
        return !podeserbaixado();
    }
    public boolean podeserbaixado(){
        return StatusReserva.RESERVADO.equals(getEspaco().getStatus());
    }
}
