package com.jp.agrodata.jpagrodata.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CargoDTO implements Serializable {

    private Integer id;

    private String nomeDoCargo;

    private String descricaoDoCargo;

    private BigDecimal salarioBase;

    private Integer horasTrabalhadas;

    private Integer codEmpresaVinculada;
}
