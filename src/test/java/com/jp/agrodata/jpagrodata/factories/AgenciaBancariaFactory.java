package com.jp.agrodata.jpagrodata.factories;

import com.jp.agrodata.jpagrodata.dtos.AgenciaBancariaDto;

public class AgenciaBancariaFactory {
    public static AgenciaBancariaDto agenciaBbDto() {
        return AgenciaBancariaDto.builder()
                .codAgencia("4276-5")
                .codBanco("001")
                .codIBGEMunicipio("H0684")
                .emailAgencia("ibituruna@bb.com.br")
                .enderecoAgencia("Av. Minas Gerais, 166")
                .foneAgencia("333271-7288")
                .foneGerente("3398412-1144")
                .NomeAgencia("Ag. Ibituruna")
                .nomeGerente("Claudisney Soares")
                .build();
    }

}
