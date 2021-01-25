package com.jp.agrodata.jpagrodata.factories;

import com.jp.agrodata.jpagrodata.dtos.EmpresaDTO;

import java.time.LocalDate;

public class EmpresaDTOFactory {
    public static EmpresaDTO criaEmpresaDTOValida() {
        return EmpresaDTO.builder()
                .cnpj("2321313213")
                .contatoEmpresa("32331530")
                .codIBGEMunicipio("H0684")
                .contatoRepresentante("33999065029")
                .emailEmpresa("tarumirim@emater.mg.gov.br")
                .emailRepresentante("joao.gusmao@emater.mg.gov.br")
                .endereco("Av. cunha, 80 - Bairro centro")
                .nomeFantasia("Escritório local da Tarumirim - EMATER/MG")
                .nomeRepresentante("João Paulo Santana Gusmão")
                .cpfRepresentante("04459471604")
                .build();
    }

    public static EmpresaDTO criaEmpresaDTOValidaComID() {
        EmpresaDTO response = EmpresaDTOFactory.criaEmpresaDTOValida();
        response.setId(110);
        return response;
    }
}
