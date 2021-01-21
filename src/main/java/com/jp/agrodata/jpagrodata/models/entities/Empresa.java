package com.jp.agrodata.jpagrodata.models.entities;

import com.jp.agrodata.jpagrodata.models.enums.EnumSimNao;
import lombok.Builder;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Data
@Builder
public class Empresa {

    private int id;

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

    private LocalDate dataAtivacao;

    private LocalDate dataDesativacao;

    @Enumerated(EnumType.STRING)
    private EnumSimNao ativo;
}
