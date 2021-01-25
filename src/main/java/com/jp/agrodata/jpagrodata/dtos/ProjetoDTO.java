package com.jp.agrodata.jpagrodata.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjetoDTO implements Serializable {

    private Integer id;
    private String descricao;
    private String nomeDoProjeto;
    private Integer codDepartamento;
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
