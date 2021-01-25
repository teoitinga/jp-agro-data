package com.jp.agrodata.jpagrodata.dtos;

import com.jp.agrodata.jpagrodata.models.entities.Banco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgenciaBancariaDTO implements Serializable {
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
