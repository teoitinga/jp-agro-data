package com.jp.agrodata.jpagrodata.dtos;

import com.jp.agrodata.jpagrodata.models.entities.Departamento;
import com.jp.agrodata.jpagrodata.models.enums.EnumRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private String cpf;
    private String matricula;
    private String senha;
    private EnumRole role;
    private Departamento departamento;
    private String registroConselho;
    private String email;
    private String endereco;
    private String foneContato;
    private String ativo;
    private String whatsapp;
    private String municipio;
}
