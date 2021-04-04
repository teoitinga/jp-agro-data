package com.jp.agrodata.jpagrodata.dtos;

import com.jp.agrodata.jpagrodata.models.enums.EnumTipoUnid;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
public class UnidadeDto implements Serializable {
    private String id;

    private String referencia;

    private String descricao;

    private String sigla;

    private String conv_si;

    private String equiv_si;

    private String tipo;
}
