package com.jp.agrodata.jpagrodata.dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
@Data
@Builder
public class DepartamentoDTO implements Serializable {
    private Integer id;
    private String nome;
    private String endereco;
    private String contato;
    private String email;
    private String nomeRepresentante;
    private String contatoRepresentante;
    private String cpfRepresentante;
    private String emailRepresentante;
    private String codIBGEMunicipio;
    private String codEmpresaVinculada;
    private String dataAtivacao;
    private String dataDesativacao;
}