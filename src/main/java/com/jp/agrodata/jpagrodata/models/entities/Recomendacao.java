package com.jp.agrodata.jpagrodata.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "TAB_RECOMENDACAO")
public class Recomendacao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private Integer id;

    @Column(name = "DESCRICAO_T250", length = 250, nullable = false)
    private String descricao;

    @ManyToMany(mappedBy = "recomendacao",fetch = FetchType.LAZY)
    private List<Servico> servicos;
}
