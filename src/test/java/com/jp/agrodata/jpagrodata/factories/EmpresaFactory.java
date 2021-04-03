package com.jp.agrodata.jpagrodata.factories;

import com.jp.agrodata.jpagrodata.dtos.EmpresaDTO;

public class EmpresaFactory {

    public static EmpresaDTO criaEmpresaPmItingaDTOValida() {
        return EmpresaDTO.builder()
                .endereco("Rua Prf. M. Antonia Gonçalves Reis, 136")
                .emailEmpresa("gabinente@itinga.mg.gov.br")
                .contatoEmpresa("33373301575")
                .cnpj("36804910000174")
                .nomeFantasia("Prefeitura Municipal de Itinga")
                .build();
    }
    public static EmpresaDTO criaEmpresaEslocDTOValida() {
        return EmpresaDTO.builder()
                .endereco("Av. Cunha, 80")
                .emailEmpresa("tarumirim@emater.mg.gov.br")
                .contatoEmpresa("3332331530")
                .cnpj("3680491000017")
                .nomeFantasia("Escritório local da Tarumirim - EMATER/MG")
                .build();
    }
    public static EmpresaDTO criaEmpresaEslocDTOSaved() {
        EmpresaDTO empresa = criaEmpresaEslocDTOValida();
        empresa.setId(1);

        return empresa;
    }
}
