package com.jp.agrodata.jpagrodata.factories;

import com.jp.agrodata.jpagrodata.dtos.SetorClassDto;

public class SetorClassFactory {
    public static SetorClassDto agricultura() {
        return SetorClassDto.builder()
                .descricao("Desenvolve ações e programas do setor agropecuário na área de abrangência da empresa")
                .nome("Agricultura")
                .build();
    }

    public static SetorClassDto esporte() {
        return SetorClassDto.builder()
                .descricao("Desenvolve ações e programas do setor esportivo na área de abrangência da empresa")
                .nome("Esportes")
                .build();
    }
    public static SetorClassDto educacao() {
        return SetorClassDto.builder()
                .descricao("Desenvolve ações e programas do setor de educação na área de abrangência da empresa")
                .nome("educação")
                .build();
    }
}
