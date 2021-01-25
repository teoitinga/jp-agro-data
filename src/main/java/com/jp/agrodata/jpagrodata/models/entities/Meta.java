package com.jp.agrodata.jpagrodata.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "TB_META")
public class Meta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "DESCRICAO_T250", length = 250, unique = false, nullable = false)
    private String descricao;

    @Column(name = "RESULTADO_T259", length = 250, unique = false, nullable = false)
    private String resultado;

    @Column(name = "DATA_INICIO_D", nullable = false)
    private LocalDate inicio;

    @Column(name = "DATA_FIM_D", nullable = false)
    private LocalDate fim;

    @Column(name = "QTD_N", nullable = false)
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "PROJETO_ID")
    private Projeto projeto;

    @ManyToOne
    @JoinColumn(name = "COD_UNIDADE")
    private Unidade unidade;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "META_ID")
    List<Servico> servicos;
}
