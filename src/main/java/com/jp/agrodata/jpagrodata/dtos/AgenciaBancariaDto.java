package com.jp.agrodata.jpagrodata.dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class AgenciaBancariaDto implements Serializable {

    private String codAgencia;

    private String NomeAgencia;

    private String codBanco;

    private String codIBGEMunicipio;

    private String enderecoAgencia;

    private String foneAgencia;

    private String nomeGerente;

    private String foneGerente;

    private String emailAgencia;
}
