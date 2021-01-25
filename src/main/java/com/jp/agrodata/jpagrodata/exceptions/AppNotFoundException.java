package com.jp.agrodata.jpagrodata.exceptions;

public class AppNotFoundException extends RuntimeException {
    public AppNotFoundException() {
        super("App não encontrado.");
    }
}
