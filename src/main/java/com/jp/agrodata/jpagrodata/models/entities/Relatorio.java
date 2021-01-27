package com.jp.agrodata.jpagrodata.models.entities;

import com.jp.agrodata.jpagrodata.models.embeddeds.Auditable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "TAB_RELATORIO")
public class Relatorio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @Lob
    @Column(name = "SITUACAO_T", unique = false, nullable = false)
    private String situacap;

    @Lob
    @Column(name = "ORIENTACAO_T", unique = false, nullable = false)
    private String orientacao;

    @Lob
    @Column(name = "RECOMENDACAO_T", unique = false, nullable = false)
    private String recomendacao;

    @OneToOne(mappedBy = "relatorio")
    private Atendimento atendimento;
}
