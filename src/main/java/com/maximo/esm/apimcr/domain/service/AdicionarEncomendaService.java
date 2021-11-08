package com.maximo.esm.apimcr.domain.service;

import com.maximo.esm.apimcr.api.mapper.EncomendaMapper;
import com.maximo.esm.apimcr.api.model.EncomendaModel;
import com.maximo.esm.apimcr.api.response.MessageResponseDTO;
import com.maximo.esm.apimcr.domain.entity.Encomenda;
import com.maximo.esm.apimcr.domain.entity.Unidade;
import com.maximo.esm.apimcr.domain.enums.StatusEncomenda;
import com.maximo.esm.apimcr.domain.exception.EncomendaNaoEncontrado;
import com.maximo.esm.apimcr.domain.exception.NegocioException;
import com.maximo.esm.apimcr.domain.repository.EncomendaRespository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class AdicionarEncomendaService {

        private final EncomendaRespository encomendaRespository;
        private final EncomendaMapper encomendaMapper;
        private UnidadeService unidadeService;

        @Transactional
        public Encomenda adicionarEncomenda (Encomenda encomenda){

            boolean notaFiscalCadastrada = encomendaRespository.
                    findByNotaFiscal(encomenda.getNotaFiscal())
                    .stream().anyMatch(NFExiste ->!NFExiste.equals(encomenda.getNotaFiscal()));
            if(notaFiscalCadastrada){
                throw new NegocioException("Nota Fiscal já cadastrada");
            }

            Unidade unidade = unidadeService.buscar(encomenda.getUnidade().getId());

            encomenda.setUnidade(unidade);
            encomenda.setStatusEncomenda(StatusEncomenda.PENDENTE);
            encomenda.setEntradaEncomenda(OffsetDateTime.now());

            return encomendaRespository.save(encomenda);
        }

    public List<EncomendaModel> listarEncomendas(){
        List<Encomenda>encomendas =encomendaRespository.findAll();
        return encomendas.stream().map(encomendaMapper::toModel)
                .collect(Collectors.toList());
    }

    public EncomendaModel findById(Long encomendaid) throws EncomendaNaoEncontrado {
        Encomenda encomenda = encomendaRespository.findById(encomendaid)
                .orElseThrow(() -> new EncomendaNaoEncontrado(encomendaid));
        return encomendaMapper.toModel(encomenda);
    }



    private MessageResponseDTO createMessageReponse(String s, Long id) {
        return MessageResponseDTO.builder().message(s + id).build();
    }

}
