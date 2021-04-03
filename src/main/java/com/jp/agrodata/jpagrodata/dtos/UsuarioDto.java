package com.jp.agrodata.jpagrodata.dtos;

import com.jp.agrodata.jpagrodata.models.entities.Cargo;
import com.jp.agrodata.jpagrodata.models.entities.Departamento;
import com.jp.agrodata.jpagrodata.models.enums.EnumRole;
import com.jp.agrodata.jpagrodata.models.enums.EnumSimNao;

import javax.persistence.*;
import java.io.Serializable;

public class UsuarioDto implements Serializable {
    private Long id;

    private String cpf;

    private String matricula;

    private String senha;

    private EnumRole role;

    private Departamento departamento;

    private String registroConselho;

    private Cargo cargo;

    private EnumSimNao ativo;

    private String email;

    private String endereco;

    private String whatsapp;

    private String foneContato;

}
