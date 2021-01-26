package com.jp.agrodata.jpagrodata.models.entities;

import com.jp.agrodata.jpagrodata.models.Pessoa;
import com.jp.agrodata.jpagrodata.models.enums.EnumRole;
import com.jp.agrodata.jpagrodata.models.enums.EnumSimNao;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@PrimaryKeyJoinColumn(name="id")
//@Table(name = "TAB_USUARIO")
@DiscriminatorValue("FUNCIONARIO")
public class Usuario extends Pessoa {

    @Column(name="CPF", nullable=false, length=11)
    private String cpf;

    @Column(name="MATRICULA", nullable=false, length=10)
    private String matricula;

    @Column(name="SENHA", nullable=false, length=512)
    private String senha;

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

    @Enumerated(EnumType.STRING)
    private EnumSimNao ativo;
}
