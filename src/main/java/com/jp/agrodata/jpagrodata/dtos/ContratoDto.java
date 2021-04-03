package com.jp.agrodata.jpagrodata.dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
public class ContratoDto  implements Serializable {

    private Integer id;

    private String objeto;

    private String servicos;

    private String dataContrato;

    private String codContratante;

    private String codContratado;

    private String codMunicipio;

}
