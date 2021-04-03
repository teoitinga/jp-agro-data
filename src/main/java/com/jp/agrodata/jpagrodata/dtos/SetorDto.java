package com.jp.agrodata.jpagrodata.dtos;

import com.jp.agrodata.jpagrodata.models.entities.SetorClass;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class SetorDto implements Serializable {

    private Integer id;

    private String nome;

    private String descricao;

    private String codEmpresaVinculada;

    private String codSetorClass;
}
