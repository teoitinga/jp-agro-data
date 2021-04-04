package com.jp.agrodata.jpagrodata.dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class BancoDto implements Serializable {

    private String codigoDoBanco;

    private String sigla;

    private String nome;
}
