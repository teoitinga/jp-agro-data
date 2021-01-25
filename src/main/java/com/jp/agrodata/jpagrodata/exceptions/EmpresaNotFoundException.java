package com.jp.agrodata.jpagrodata.exceptions;

public class EmpresaNotFoundException extends RuntimeException {
    public EmpresaNotFoundException() {
        super("Esta empresa não existe no banco de dados.");
    }
}
