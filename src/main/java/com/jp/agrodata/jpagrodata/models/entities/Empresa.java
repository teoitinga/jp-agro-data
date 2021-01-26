package com.jp.agrodata.jpagrodata.models.entities;

import com.jp.agrodata.jpagrodata.models.enums.EnumSimNao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
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

    @Column(name="NOME_REPRESENTANTE", nullable=false, length=50)
    private String nomeRepresentante;

    @Column(name="CONTATO_REPRESENTANTE", nullable=false, length=12)
    private String contatoRepresentante;

    @Column(name="CPF_REPRESENTANTE", nullable=false, length=11)
    private String cpfRepresentante;

    @Column(name="EMAIL_REPRESENTANTE", nullable=false, length=50)
    private String emailRepresentante;

    @Column(name="COD_IBGE_MUNICIPIO", nullable=false, length=10)
    private String codIBGEMunicipio;

    @OneToMany(mappedBy = "empresa")
    private List<Message> messages;

    @OneToOne
    private Contrato contrato;

    @OneToMany(mappedBy = "empresaVinculada")
    private List<Cargo> cargos;

    @OneToMany(mappedBy = "empresaVinculada")
    private List<Departamento> departamentos;

}
