package com.jp.agrodata.jpagrodata.factories;

import com.jp.agrodata.jpagrodata.dtos.PlanoDto;

import java.math.BigDecimal;

public class PlanoFactory {
    public static PlanoDto planoPadraoDto() {
        return PlanoDto.builder()
                .qtd_acao(5)
                .qtd_departamento(2)
                .qtd_funcionario(4)
                .qtd_meta(3)
                .qtd_projeto(3)
                .tmp_licenca(2)
                .valor_contrato(BigDecimal.valueOf(998.35))
                .build();
    }
    public static PlanoDto planoPadraoSavedDto() {

        PlanoDto planoDto = planoPadraoDto();
        planoDto.setId(1);

        return planoDto;
    }
}
