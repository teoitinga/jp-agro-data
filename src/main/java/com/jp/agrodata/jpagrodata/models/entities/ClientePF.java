package com.jp.agrodata.jpagrodata.models.entities;

import com.jp.agrodata.jpagrodata.embeddeds.Pessoa;
import com.jp.agrodata.jpagrodata.models.enums.EnumCategoria;
import com.jp.agrodata.jpagrodata.models.enums.EnumEscolaridade;
import com.jp.agrodata.jpagrodata.models.enums.EnumGenero;
import com.jp.agrodata.jpagrodata.models.enums.EnumRaca;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@DiscriminatorValue("PESSOA_FISICA")
public class ClientePF extends Pessoa {


    @Column(name="CPF_T11", nullable=false, length=11)
    private String cpf;

    @Column(name="APELIDO_T20", nullable=false, length=20)
    private String apelido;

    @Column(name="DATA_NASCIMENTO_D", nullable=true)
    private LocalDate dataDeNascimento;

    @Column(name="ESCOLARIDADE_T30", nullable=true, columnDefinition = "varchar(30) default 'NAO_INFORMADO'")
    @Enumerated(EnumType.STRING)
    private EnumEscolaridade escolaridade;

    @Column(name="GENERO_T30", nullable=true, columnDefinition = "varchar(30) default 'NAO_INFORMADO'")
    @Enumerated(EnumType.STRING)
    private EnumGenero genero;

    @Column(name="CATEGORIA_T30", nullable=true, columnDefinition = "varchar(30) default 'NAO_INFORMADO'")
    @Enumerated(EnumType.STRING)
    private EnumCategoria categoria;

    @Column(name="RACA_COR_T30", nullable=true, columnDefinition = "varchar(30) default 'NAO_INFORMADO'")
    @Enumerated(EnumType.STRING)
    private EnumRaca raca;

}
