package com.jp.agrodata.jpagrodata.models.entities;

import com.jp.agrodata.jpagrodata.embeddeds.Pessoa;
import com.jp.agrodata.jpagrodata.models.enums.EnumRole;
import com.jp.agrodata.jpagrodata.models.enums.EnumSimNao;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("FUNCIONARIO")
public class Usuario extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", nullable=true, unique = true)
    private Long id;

    @Column(name="CPF", nullable=false, length=11)
    private String cpf;

    @Column(name="MATRICULA", nullable=false, length=10)
    private String matricula;

    @Column(name="SENHA", nullable=false, length=512)
    private String senha;

    @Column(name="PERMISSAO_ENUM", nullable=false, length=50)
    @Enumerated(EnumType.STRING)
    private EnumRole role;

    @ManyToOne
    @JoinColumn(name = "COD_DEPARTAMENTO")
    private Departamento departamento;

    @Column(name="REGISTRO_CONSELHO", nullable=false, length=20)
    private String registroConselho;

    @ManyToOne
    @JoinColumn(name = "ID_CARGO")
    private Cargo cargo;

    @Column(name="ATIVO_ENUM", nullable=false, length=3)
    @Enumerated(EnumType.STRING)
    private EnumSimNao ativo;
}
