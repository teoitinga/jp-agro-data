package com.jp.agrodata.jpagrodata.factories;

import com.jp.agrodata.jpagrodata.dtos.ContaBancariaDto;

public class ContaBancariaFactory {
    public static ContaBancariaDto contaCorrenteDto() {
        return ContaBancariaDto.builder()
                .codAgencia("4276-5")
                .codEmpresa("1")
                .numConta("20.960-0")
                .build();
    }

    public static ContaBancariaDto contaCorrenteSavedDto() {
        ContaBancariaDto contaCorrenteDto = contaCorrenteDto();
        contaCorrenteDto.setId("1");
        return contaCorrenteDto;
    }
}
