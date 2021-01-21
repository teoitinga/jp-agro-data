package com.jp.agrodata.jpagrodata.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private String id;
    private String nome;
    private String apelido;
    private String dataDeNascimento;
    private String escolaridade;
    private String genero;
    private String contato;
    private String categoria;
    private String raca;
    private String email;
    private String endereco;
    private String whatsapp;
    private String cpf;
}
