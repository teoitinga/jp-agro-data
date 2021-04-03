package com.jp.agrodata.jpagrodata.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "TAB_DEPARTAMENTO")
public class Departamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="NOME_DEPARTAMENTO", nullable=false, length=30)
    private String nome;

    @Column(name="ENDERECO_DEPARTAMENTO", nullable=false, length=50)
    private String endereco;

    @Column(name="CONTATO_DEPARTAMENTO", nullable=false, length=15)
    private String contato;

    @Column(name="EMAIL_DEPARTAMENTO", nullable=false, length=50)
    private String email;

    @ManyToOne
    @JoinColumn(name = "REPRESENTANTE_ID")
    private Usuario representante;

    @ManyToOne
    @JoinColumn(name = "SETOR_COD")
    private Setor setor;

    @Column(name="DATA_ATIVACAO", nullable=false)
    private LocalDate dataAtivacao;

    @Column(name="DATA_DESATIVACAO", nullable=true)
    private LocalDate dataDesativacao;
}
