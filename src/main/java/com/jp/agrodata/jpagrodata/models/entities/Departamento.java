package com.jp.agrodata.jpagrodata.models.entities;

import com.jp.agrodata.jpagrodata.models.enums.EnumSetor;
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

    @Column(name="NOME_REPRESENTANTE", nullable=false, length=50)
    private String nomeRepresentante;

    @Column(name="CONTATO_REPRESENTANTE", nullable=false, length=15)
    private String contatoRepresentante;

    @Column(name="CPF_REPRESENTANTE", nullable=false, length=15)
    private String cpfRepresentante;

    @Column(name="EMAIL_REPRESENTANTE", nullable=false, length=50)
    private String emailRepresentante;

    @Column(name="COD_IBGE_MUNICIPIO", nullable=false, length=15)
    private String codIBGEMunicipio;

    @ManyToOne
    @JoinColumn(name = "cod_empresa_vinculada")
    private Empresa empresaVinculada;

    @Enumerated(EnumType.STRING)
    private EnumSetor setor;

    @Column(name="DATA_ATIVACAO", nullable=false)
    private LocalDate dataAtivacao;

    @Column(name="DATA_DESATIVACAO", nullable=true)
    private LocalDate dataDesativacao;
}
