package com.jp.agrodata.jpagrodata.factories;

import com.jp.agrodata.jpagrodata.dtos.ProjetoDTO;

public class ProjetoDTOFactory {
    public static ProjetoDTO criaDTOValidoComID() {
        ProjetoDTO response = ProjetoDTOFactory.criaDTOValido();
        response.setId(123);

        return response;
    }

    public static ProjetoDTO criaDTOValido() {
        return ProjetoDTO.builder()
                .codIBGEMunicipio("H0684")
                .codDepartamento(0012)
                .cpfResponsavel("04459471604")
                .descricao("Program de distribuição de sementes de hortaliçcas")
                .inicio("01/01/2021")
                .fim("31/12/2021")
                .justificativa("O povo necessita de plantar hortaliças")
                .nomeDoProjeto("Boa horta")
                .numDeBeneficiarios(250)
                .objetivoEspecifico("Fazer o povo comer plantinhas")
                .objetivoGeral("Melhorar a alimentação de povo gordo")
                .parceiros("EMATER; Sindicato")
                .publicoAlvo("Pessoas em situação de vulnerabilidade social")
                .resultadosEsperados("Reduzir os indices de desnutrição no município")
                .valorOrcado(3544.56)
                .build();
    }
}
