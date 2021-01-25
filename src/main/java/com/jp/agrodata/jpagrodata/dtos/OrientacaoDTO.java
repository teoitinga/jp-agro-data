package com.jp.agrodata.jpagrodata.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrientacaoDTO  implements Serializable {
    private Integer id;

    private String descricao;

    private List<Integer> codServicos;
}
