package com.jp.agrodata.jpagrodata.factories;

import com.jp.agrodata.jpagrodata.dtos.SetorDto;

public class SetorFactory {
    public static SetorDto setorAgricultura() {
        return SetorDto.builder()
                .codEmpresaVinculada("1")
                .descricao("Desenvolve programas municipais para apoio e desenvolvimento da agropecuária no municipio")
                .nome("Secretaria Municipal de Agricultura e pecuária")
                .build();
    }
    public static SetorDto setorEsporte() {
        return SetorDto.builder()
                .codEmpresaVinculada("1")
                .descricao("Desenvolve programas municipais para apoio e desenvolvimento da agropecuária no municipio")
                .nome("Secretaria Municipal de Agricultura e pecuária")
                .build();
    }
}
