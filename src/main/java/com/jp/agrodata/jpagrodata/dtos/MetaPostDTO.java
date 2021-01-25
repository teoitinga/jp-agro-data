package com.jp.agrodata.jpagrodata.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MetaPostDTO implements Serializable {

    private String descricao;

    private String resultado;

    private String inicio;

    private String fim;

    private Integer quantidade;

    private Integer codProjeto;

    private Integer codUnidade;

    List<Integer> servicos;
}
