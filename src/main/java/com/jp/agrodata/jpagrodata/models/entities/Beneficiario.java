package com.jp.agrodata.jpagrodata.models.entities;

import com.jp.agrodata.jpagrodata.embeddeds.Pessoa;
import com.jp.agrodata.jpagrodata.models.embeddeds.Auditable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TAB_BENEFICIARIO")
public class Beneficiario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "PUBLICO_ID")
    private Pessoa publico;

    @Column(name = "QTD_N", precision = 6, scale = 2)
    private BigDecimal quantidade;

    @ManyToOne
    @JoinColumn(name = "SERVICO_ID")
    private Servico servicos;
}
