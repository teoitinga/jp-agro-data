package com.jp.agrodata.jpagrodata.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "TAB_PLANO")
public class Plano  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="QTD_DEPARTAMENTO", nullable=false)
    private Integer qtd_departamento;

    @Column(name="QTD_PROJETO", nullable=false)
    private Integer qtd_projeto;

    @Column(name="QTD_ACAO", nullable=false)
    private Integer qtd_acao;

    @Column(name="QTD_META", nullable=false)
    private Integer qtd_meta;

    @Column(name="QTD_FUNCIONARIO", nullable=false)
    private Integer qtd_funcionario;

    @Column(name="TMP_LICENCA", nullable=false)
    private Integer tmp_licenca;

    @Column(name="VALOR_CONTRATO", precision = 6, scale = 2)
    private BigDecimal valor_contrato;

}
