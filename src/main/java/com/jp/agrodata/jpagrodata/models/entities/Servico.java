package com.jp.agrodata.jpagrodata.models.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TAB_SERVICOS")

public class Servico implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private Integer id;

    @Column(name = "DESCRICAO_T250", length = 250, nullable = false)
    private String descricao;

    @Column(name = "REFERENCIA_T50", length = 50, nullable = false)
    private String referencia;

    @Column(name = "TEMPO_NECESS_N", nullable = false)
    private Integer tempoNecessario;

    @Column(name = "VALOR_ORCADO_ND", nullable = false)
    private BigDecimal valor;

    @ManyToMany(mappedBy = "servicos",fetch = FetchType.LAZY)
    private List<Meta> meta;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "SERVICO_ID")
    private Collection<Situacao> situacao;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "SERVICO_ID")
    private List<Orientacao> orientacao;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "SERVICO_ID")
    private List<Recomendacao> recomendacao;
}
