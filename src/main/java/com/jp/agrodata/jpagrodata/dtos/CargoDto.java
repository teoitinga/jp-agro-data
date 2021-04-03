package com.jp.agrodata.jpagrodata.dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
public class CargoDto  implements Serializable {

    private Integer id;

    private String nomeDoCargo;

    private String descricaoDoCargo;

    private BigDecimal salarioBase;

    private Integer horasTrabalhadas;

    private String codEmpresaVinculada;
}
