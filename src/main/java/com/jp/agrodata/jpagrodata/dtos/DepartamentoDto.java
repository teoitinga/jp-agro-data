package com.jp.agrodata.jpagrodata.dtos;

import com.jp.agrodata.jpagrodata.models.enums.EnumSetor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
@Data
@Builder
public class DepartamentoDto  implements Serializable {

    private Integer id;

    private String nome;

    private String endereco;

    private String contato;

    private String email;

    private SetorDto setor;

}
