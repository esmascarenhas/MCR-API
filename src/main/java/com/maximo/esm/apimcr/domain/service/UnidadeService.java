package com.maximo.esm.apimcr.domain.service;

import com.maximo.esm.apimcr.domain.entity.Unidade;
import com.maximo.esm.apimcr.domain.exception.NegocioException;
import com.maximo.esm.apimcr.domain.repository.UnidadeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class UnidadeService {


    private UnidadeRepository unidadeRepository;

  /*  public List<Unidade> listar(){
        return unidadeRepository.findAll();

    }*/
    @Transactional
    public Unidade salvar(Unidade unidade){

        return unidadeRepository.save(unidade);
    }

    public Unidade buscar (Long unidadeid){
        return unidadeRepository.findById(unidadeid)
                .orElseThrow(()-> new NegocioException("Unidade não encontrada. "));
    }
    @Transactional
    public void excluirUnidade(Long unidadeid){
        unidadeRepository.deleteById(unidadeid);
    }

}
