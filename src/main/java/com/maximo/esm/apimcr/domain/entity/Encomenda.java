package com.maximo.esm.apimcr.domain.entity;

import com.maximo.esm.apimcr.domain.enums.StatusEncomenda;
import com.maximo.esm.apimcr.domain.exception.NegocioException;
import com.maximo.esm.apimcr.domain.repository.EncomendaRespository;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Encomenda extends RepresentationModel<Encomenda> {



    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Unidade unidade;

    @Embedded
    private Destinatario destinatario;

    @NotBlank
    @Column(unique = true)
    private String notaFiscal;

    @Enumerated(EnumType.STRING )
    private StatusEncomenda statusEncomenda;

    private OffsetDateTime entradaEncomenda;
    private OffsetDateTime baixaEncomenda;


    @OneToMany(mappedBy = "encomenda" , cascade = CascadeType.ALL)
    private List<OcorrenciaEncomenda> ocorrenciaEncomendas = new ArrayList<>();

    public OcorrenciaEncomenda adicionarOcorrenciaEncomenda(String descricao){
        OcorrenciaEncomenda ocorrenciaEncomenda = new OcorrenciaEncomenda();

        ocorrenciaEncomenda.setDescricao(descricao);
        ocorrenciaEncomenda.setDataRegistro(OffsetDateTime.now());
        ocorrenciaEncomenda.setEncomenda(this);

        return ocorrenciaEncomenda;
    }
    public void baixarEncomenda(){
        if(naopodeserbaixado()){
            throw new NegocioException("Encomenda não pode ser baixada");
        }
        setStatusEncomenda(StatusEncomenda.ENTREGUE);
        setBaixaEncomenda(OffsetDateTime.now());
            }
    public boolean naopodeserbaixado(){

        return !podeserbaixado();
    }

    public boolean podeserbaixado() {

        return statusEncomenda.PENDENTE.equals(getStatusEncomenda());
    }




}
