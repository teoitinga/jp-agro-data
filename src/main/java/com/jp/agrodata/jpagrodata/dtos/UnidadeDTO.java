package com.jp.agrodata.jpagrodata.dtos;

import com.jp.agrodata.jpagrodata.models.enums.EnumTipoUnid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UnidadeDTO implements Serializable {

    private String referencia;

    private String descricao;

    private String sigla;

    private BigDecimal conv_si;

    private String equiv_si;

    private EnumTipoUnid tipo;
}
