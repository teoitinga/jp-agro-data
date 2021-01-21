package com.jp.agrodata.jpagrodata.factories;

import com.jp.agrodata.jpagrodata.dtos.DepartamentoDTO;

public class DepartamentoDTOFactory {
    public static DepartamentoDTO criaDTOValido() {
        return DepartamentoDTO.builder()
                .codEmpresaVinculada("123")
                .codIBGEMunicipio("H0684")
                .contato("32331530")
                .contatoRepresentante("99906-5029")
                .cpfRepresentante("04459471604")
                .dataAtivacao("04/01/2021")
                .dataDesativacao("14/08/2022")
                .email("tarumirim@emater.mg.gov.br")
                .emailRepresentante("joao.gusmao@emater.mg.gov.br")
                .endereco("Av. Cunha, 80")
                .nome("Secretaria de Agricultura")
                .nomeRepresentante("Marculino")
                .build();
    }

    public static DepartamentoDTO criaDTOValidoComID() {
        DepartamentoDTO response = DepartamentoDTOFactory.criaDTOValido();
        response.setId(123);
        return response;
    }
}
