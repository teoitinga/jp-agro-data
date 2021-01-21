package com.jp.agrodata.jpagrodata.dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class EmpresaDTO implements Serializable {
    private Integer id;
    private String cnpj;
    private String nomeFantasia;
    private String endereco;
    private String contatoEmpresa;
    private String emailEmpresa;
    private String nomeRepresentante;
    private String contatoRepresentante;
    private String cpfRepresentante;
    private String emailRepresentante;
    private String codIBGEMunicipio;
    private String dataAtivacao;
    private String dataDesativacao;
    private String ativo;
}
