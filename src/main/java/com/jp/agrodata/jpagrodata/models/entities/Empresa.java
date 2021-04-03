package com.jp.agrodata.jpagrodata.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TAB_EMPRESA")
public class Empresa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", nullable=false, length=14)
    private Integer id;

    @Column(name="CNPJ_EMPRESA", unique=true, nullable=false, length=14)
    private String cnpj;

    @Column(name="NOME_FANTASIA", nullable=false, length=50)
    private String nomeFantasia;

    @Column(name="ENDERECO_EMPRESA", nullable=false, length=50)
    private String endereco;

    @Column(name="CONTATO_EMPRESA", nullable=false, length=12)
    private String contatoEmpresa;

    @Column(name="EMAIL_EMPRESA", nullable=false, length=50)
    private String emailEmpresa;

    @ManyToOne
    @JoinColumn(name = "REPRESENTANTE_ID")
    private Usuario representante;

    @OneToMany(mappedBy = "empresaVinculada")
    private List<Cargo> cargos;

    @OneToMany(mappedBy = "empresaVinculdada")
    private List<Setor> setores;

    @OneToOne
    @JoinColumn(name = "contrato_codigo")
    private Contrato contrato;

}
