package com.jp.agrodata.jpagrodata.exceptions;

public class DepartamentoNotFoundException extends RuntimeException {
    public DepartamentoNotFoundException() {
        super("Este departamento não existe no banco de dados.");
    }
}
