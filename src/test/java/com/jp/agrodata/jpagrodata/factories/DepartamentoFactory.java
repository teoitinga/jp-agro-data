package com.jp.agrodata.jpagrodata.factories;

import com.jp.agrodata.jpagrodata.dtos.DepartamentoDto;

import java.util.ArrayList;
import java.util.List;

public class DepartamentoFactory {
    public static List<DepartamentoDto> departamentosDto() {
        List<DepartamentoDto> departamentos = new ArrayList<>();

        departamentos.add(departamentoAgricultura());
        departamentos.add(departamentoEsporte());

        return departamentos;
    }

    private static DepartamentoDto departamentoAgricultura() {
        return DepartamentoDto.builder()
                .contato("3332331530")
                .email("agricultura@tarumirim.mg.gov.br")
                .nome("Secretaria Municipal de Agricultura")
                .setor(SetorFactory.setorAgricultura())
                .endereco("Av. Cunha, 80")
                .build();
    }

    private static DepartamentoDto departamentoEsporte() {
        return DepartamentoDto.builder()
                .contato("3332331530")
                .email("esporte@tarumirim.mg.gov.br")
                .nome("Secretaria Municipal de Esporte, lazer e cultura")
                .setor(SetorFactory.setorEsporte())
                .endereco("Av. Cunha, 80")
                .build();
    }

}
