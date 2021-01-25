package com.jp.agrodata.jpagrodata.dtos;

import com.jp.agrodata.jpagrodata.models.entities.AgenciaBancaria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContaBancariaDTO implements Serializable {

    private Integer id;

    private String codAgencia;

    private String numConta;
}
