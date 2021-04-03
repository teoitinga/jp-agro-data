package com.jp.agrodata.jpagrodata.dtos;

import com.jp.agrodata.jpagrodata.models.entities.Contrato;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ClausulaDto implements Serializable {

    private Integer id;

    private Integer numero;

    private String description;

}
