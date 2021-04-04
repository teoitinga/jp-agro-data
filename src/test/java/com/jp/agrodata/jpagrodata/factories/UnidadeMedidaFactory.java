package com.jp.agrodata.jpagrodata.factories;

import com.jp.agrodata.jpagrodata.dtos.UnidadeDto;

public class UnidadeMedidaFactory {
    public static UnidadeDto linearMetroDto() {
        return UnidadeDto.builder()
                .conv_si("m")
                .descricao("metro linear")
                .equiv_si("1")
                .referencia("metro")
                .sigla("m")
                .tipo("LINEAR")
                .build();
    }
}
