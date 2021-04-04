package com.jp.agrodata.jpagrodata.dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ContaBancariaDto implements Serializable {

    private String id;

    private String codAgencia;

    private String codEmpresa;

    private String numConta;
}
