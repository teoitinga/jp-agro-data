package com.jp.agrodata.jpagrodata.exceptions;

public class UnidadeNotFoundException extends RuntimeException {
    public UnidadeNotFoundException() {
        super("Unidade não registrada no banco de dados.");
    }
}
