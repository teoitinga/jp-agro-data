package com.jp.agrodata.jpagrodata.dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
@Data
@Builder
public class PlanoDto implements Serializable {

    private Integer id;

    private Integer qtd_departamento;

    private Integer qtd_projeto;

    private Integer qtd_acao;

    private Integer qtd_meta;

    private Integer qtd_funcionario;

    private Integer tmp_licenca;

    private BigDecimal valor_contrato;

    private ContratoDto contrato;
}
