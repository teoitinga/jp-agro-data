package com.jp.agrodata.jpagrodata.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "TAB_SETOR")
public class Setor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="NOME_SETOR", nullable=false, length=30)
    private String nome;

    @Column(name="DESCRICAO_SETOR", nullable=false, length=30)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "CLASSE_ST")
    private SetorClass setorClass;

    @ManyToOne
    @JoinColumn(name = "EMPRESA_CNPJ")
    private Empresa empresaVinculdada;
}
