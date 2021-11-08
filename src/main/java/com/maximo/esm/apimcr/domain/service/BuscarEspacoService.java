package com.maximo.esm.apimcr.domain.service;

import com.maximo.esm.apimcr.domain.entity.Espaco;
import com.maximo.esm.apimcr.domain.repository.EspacoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BuscarEspacoService {

    private EspacoRepository espacoRepository;

    public List<Espaco>listarEspacos(){
        return espacoRepository.findAll();
    }
}
