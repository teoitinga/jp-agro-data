package com.jp.agrodata.jpagrodata.models.entities;

import com.jp.agrodata.jpagrodata.models.Pessoa;
import com.jp.agrodata.jpagrodata.models.enums.EnumCategoria;
import com.jp.agrodata.jpagrodata.models.enums.EnumEscolaridade;
import com.jp.agrodata.jpagrodata.models.enums.EnumGenero;
import com.jp.agrodata.jpagrodata.models.enums.EnumRaca;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name="PK_PESSOA_FISICA", referencedColumnName="id")
public class ClientePF extends Pessoa {

    private String cpf;

    private String apelido;

    private LocalDate dataDeNascimento;

    @Enumerated(EnumType.STRING)
    private EnumEscolaridade escolaridade;

    @Enumerated(EnumType.STRING)
    private EnumGenero genero;

    @Enumerated(EnumType.STRING)
    private EnumCategoria categoria;

    @Enumerated(EnumType.STRING)
    private EnumRaca raca;
}
