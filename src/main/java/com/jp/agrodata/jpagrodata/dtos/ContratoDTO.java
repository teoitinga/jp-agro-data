package com.jp.agrodata.jpagrodata.dtos;

import com.jp.agrodata.jpagrodata.models.entities.Empresa;
import com.jp.agrodata.jpagrodata.models.entities.Root;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContratoDTO implements Serializable {

    private Integer id;

    private String clausulas;

    private String idApp;

    private String dataContrato;

    private String fimVigencia;

    private String cnpjContratante;

    private BigDecimal valor;

    private String objeto;

    private String servicos;

    private String remuneracao;
}
