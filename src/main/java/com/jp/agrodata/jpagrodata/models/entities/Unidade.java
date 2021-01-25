package com.jp.agrodata.jpagrodata.models.entities;

import com.jp.agrodata.jpagrodata.models.enums.EnumTipoUnid;
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
@Table(name = "TB_UNID_MED")
public class Unidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private Integer id;

    @Column(name = "REF_T15", length = 15, nullable = false)
    private String referencia;

    @Column(name = "DESC_T50", length = 50, nullable = false)
    private String descricao;

    @Column(name = "SIGLA_T5", length = 5, nullable = false)
    private String sigla;

    @Column(name = "CONV_SI_ND", nullable = false, precision = 8, scale = 3)
    private BigDecimal conv_si;

    @Column(name = "EQU_SI_T10", length = 10, nullable = false)
    private String equiv_si;

    @Enumerated(EnumType.STRING)
    private EnumTipoUnid tipo;
}
