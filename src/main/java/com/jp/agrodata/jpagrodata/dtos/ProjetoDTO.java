package com.jp.agrodata.jpagrodata.dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
@Data
@Builder
public class ProjetoDTO implements Serializable {

    private Integer id;
    private String descricao;
    private String nomeDoProjeto;
    private String codDepartamento;
    private String objetivoGeral;
    private String objetivoEspecifico;
    private String justificativa;
    private String resultadosEsperados;
    private String parceiros;
    private String inicio;
    private String fim;
    private String publicoAlvo;
    private String cpfResponsavel;
    private String codIBGEMunicipio;
    private Integer numDeBeneficiarios;
    private Double valorOrcado;

}
