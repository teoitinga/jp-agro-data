package com.jp.agrodata.jpagrodata.dtos;

import com.jp.agrodata.jpagrodata.models.entities.Empresa;
import com.jp.agrodata.jpagrodata.models.enums.EnumSetor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    private Integer CodEmpresaVinculada;
    private EnumSetor setor;
    private String dataAtivacao;
    private String dataDesativacao;
}