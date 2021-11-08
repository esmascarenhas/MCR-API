package com.maximo.esm.apimcr.domain.exception;

public class EncomendaNaoEncontrado extends Exception {
    public EncomendaNaoEncontrado(Long encomendaid) {
        super(String.format("Encomenda com o ID %s não encontrada",encomendaid));
    }
}
