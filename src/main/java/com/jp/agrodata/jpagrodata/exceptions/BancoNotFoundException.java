package com.jp.agrodata.jpagrodata.exceptions;

public class BancoNotFoundException extends RuntimeException {
    public BancoNotFoundException() {
        super("Este Banco não está cadastrado em nosso banco de dados.");
    }
}
