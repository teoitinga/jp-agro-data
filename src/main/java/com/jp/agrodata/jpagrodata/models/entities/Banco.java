package com.jp.agrodata.jpagrodata.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "TAB_BANCO")
public class Banco implements Serializable {

    @Id
    @Column(name="ID", nullable=false, length=6)
    private String codigoDoBanco;

    @Column(name="SIGLA_BANCO", nullable=false, length=10)
    private String sigla;

    @Column(name="NOME_BANCO", nullable=false, length=20)
    private String nome;
}
