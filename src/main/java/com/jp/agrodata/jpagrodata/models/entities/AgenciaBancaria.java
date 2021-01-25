package com.jp.agrodata.jpagrodata.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "TAB_AGENCIA_BANCARIA")
public class AgenciaBancaria implements Serializable {

    @Id
    @Column(name="NUM_AGENCIA", nullable=false, length=10)
    private String codAgencia;

    @Column(name="NOME_AGENCIA", nullable=false, length=10)
    private String NomeAgencia;

    @ManyToOne
    @JoinColumn(name = "COD_BANCO")
    private Banco banco;

    @Column(name="COD_IBGE_MUNICIPIO", nullable=false, length=10)
    private String codIBGEMunicipio;

    @Column(name="ENDERECO_AGENCIA", nullable=false, length=50)
    private String enderecoAgencia;

    @Column(name="FONE_AGENCIA", nullable=false, length=15)
    private String foneAgencia;

    @Column(name="NOME_GERENTE", nullable=false, length=50)
    private String nomeGerente;

    @Column(name="FONE_GERENTE", nullable=false, length=15)
    private String foneGerente;

    @Column(name="EMAIL_AGENCIA", nullable=false, length=50)
    private String emailAgencia;

}
