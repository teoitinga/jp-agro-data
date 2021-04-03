package com.jp.agrodata.jpagrodata.dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class SetorClassDto implements Serializable {

    private Integer id;

    private String nome;

    private String descricao;
}
