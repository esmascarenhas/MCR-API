package com.maximo.esm.apimcr.api.controller;

import com.maximo.esm.apimcr.api.mapper.UnidadeMapper;
import com.maximo.esm.apimcr.api.model.UnidadeModel;
import com.maximo.esm.apimcr.api.model.input.UnidadeInput;
import com.maximo.esm.apimcr.domain.entity.Unidade;
import com.maximo.esm.apimcr.domain.repository.UnidadeRepository;
import com.maximo.esm.apimcr.domain.service.UnidadeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1/unidades")
@Api(value = "MCR API REST - Controle de Unidades")
public class UnidadeController {

    private UnidadeRepository unidadeRepository;
    private UnidadeService unidadeService;
    private UnidadeMapper unidadeMapper;

    @GetMapping
    @ApiOperation(value = "Listar de unidades")
    public CollectionModel  <UnidadeModel> listarUnidades(){

        return unidadeMapper.toCollectionModel(unidadeRepository.findAll());
    }

    @GetMapping("/{unidadeid}")
    @ApiOperation(value = "Busca uma unidade específica")
    public ResponseEntity<UnidadeModel>buscar(@PathVariable Long unidadeid){
        return unidadeRepository.findById(unidadeid)
                .map(unidade -> ResponseEntity.ok(unidadeMapper.toModel(unidade)))
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Adiciona uma reserva")
    public UnidadeModel adicionar(@Valid @RequestBody UnidadeInput unidadeInput){
        Unidade novaUnidade = unidadeMapper.toEntity(unidadeInput);
        Unidade unidadeCadastrada = unidadeService.salvar(novaUnidade);
        return unidadeMapper.toModel(unidadeCadastrada);

    }
    @PutMapping("/{unidadeid}")
    @ApiOperation(value = "atualiza uma unidade específica")
    public ResponseEntity<Unidade>atualizarUnidade(@PathVariable Long unidadeid,
        @Valid @PathVariable Unidade unidade){
        if(!unidadeRepository.existsById(unidadeid)){
            return ResponseEntity.notFound().build();
        }
        unidade.setId(unidadeid);
        unidade = unidadeService.salvar(unidade);

        return ResponseEntity.ok(unidade);

    }

    @DeleteMapping("/{unidadeid}")
    public ResponseEntity<Void>excluirUnidade(@PathVariable Long unidadeid){
        if(!unidadeRepository.existsById(unidadeid)){
            return ResponseEntity.notFound().build();
        }
        unidadeService.excluirUnidade(unidadeid);
        return ResponseEntity.noContent().build();
    }

}
