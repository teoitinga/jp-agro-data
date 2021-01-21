package com.jp.agrodata.jpagrodata.models.entities;

import com.jp.agrodata.jpagrodata.models.Pessoa;
import com.jp.agrodata.jpagrodata.models.enums.EnumRole;
import com.jp.agrodata.jpagrodata.models.enums.EnumSimNao;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name="id")
public class Usuario extends Pessoa {

    private String cpf;

    private String matricula;

    private String senha;

    @Enumerated(EnumType.STRING)
    private EnumRole role;

    private Departamento departamento;

    private String registroConselho;

    @Enumerated(EnumType.STRING)
    private EnumSimNao ativo;
}
