package com.jp.agrodata.jpagrodata.exceptions;

public class ProjetoNotFoundException extends RuntimeException {
    public ProjetoNotFoundException() {
        super("Projeto não cadastrado no banco de dados.");
    }
}
