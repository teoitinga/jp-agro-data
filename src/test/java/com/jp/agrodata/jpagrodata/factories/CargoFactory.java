package com.jp.agrodata.jpagrodata.factories;

import com.jp.agrodata.jpagrodata.dtos.CargoDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CargoFactory {

    public static List<CargoDto> cargosDto() {
        List<CargoDto> cargos = new ArrayList<>();
        cargos.add(cargoAnalistaDto());
        cargos.add(cargoDiretorAgriculturaDto());
        cargos.add(cargoSercretarioAgriculturaDto());
        cargos.add(cargoChefeExecutivoDto());

        return cargos;
    }

    public static CargoDto cargoAnalistaDto() {
        return CargoDto.builder()
                .codEmpresaVinculada("36804910000174")
                .descricaoDoCargo("analisa as informações exitentes no banco da dados e gera relatórios com informações estatísticas")
                .horasTrabalhadas(40)
                .nomeDoCargo("analista de dados")
                .salarioBase(BigDecimal.valueOf(3500.0))
                .build();
    }
    public static CargoDto cargoSercretarioAgriculturaDto() {
        return CargoDto.builder()
                .codEmpresaVinculada("36804910000174")
                .descricaoDoCargo("Gerencia e implementa ações referentes ao setor agrícola do município")
                .horasTrabalhadas(40)
                .nomeDoCargo("Secretario de Agricultura")
                .salarioBase(BigDecimal.valueOf(4250.0))
                .build();
    }
    public static CargoDto cargoDiretorAgriculturaDto() {
        return CargoDto.builder()
                .codEmpresaVinculada("36804910000174")
                .descricaoDoCargo("Auxilia o superior imediato nas ações referentes ao setor agrícola do município")
                .horasTrabalhadas(40)
                .nomeDoCargo("Diretor de programas agrocolas")
                .salarioBase(BigDecimal.valueOf(1850.0))
                .build();
    }
    public static CargoDto cargoChefeExecutivoDto() {
        return CargoDto.builder()
                .codEmpresaVinculada("36804910000174")
                .descricaoDoCargo("Gerencia e responsabiliza por todas as ações do município")
                .horasTrabalhadas(40)
                .nomeDoCargo("chefe Executivo")
                .salarioBase(BigDecimal.valueOf(12425.0))
                .build();
    }

}
