package com.jp.agrodata.jpagrodata.factories;

import com.jp.agrodata.jpagrodata.dtos.BancoDto;

public class BancoFactory {
    public static BancoDto bancoBbDto() {
        return BancoDto.builder()
                .codigoDoBanco("001")
                .sigla("BB")
                .nome("Banco do Brasil")
                .build();
    }
    public static BancoDto bancoSicoobDto() {
        return BancoDto.builder()
                .codigoDoBanco("002")
                .sigla("SICOOB")
                .nome("Banco Sicoob")
                .build();
    }
}
