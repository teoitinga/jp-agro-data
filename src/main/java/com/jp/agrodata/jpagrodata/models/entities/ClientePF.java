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

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
//#@PrimaryKeyJoinColumn(name="PK_PESSOA_FISICA", referencedColumnName="id")
//@Table(name = "TAB_CLIENTE_PF")
@DiscriminatorValue("PESSOA_FISICA")
public class ClientePF extends Pessoa {

    @Column(name="CPF", nullable=false, length=11)
    private String cpf;

    @Column(name="APELIDO", nullable=false, length=20)
    private String apelido;

    @Column(name="DATA_NASCIMENTO", nullable=true)
    private LocalDate dataDeNascimento;

    @Column(name="ESCOLARIDADE", nullable=true, columnDefinition = "varchar(30) default 'NAO_INFORMADO'")
    @Enumerated(EnumType.STRING)
    private EnumEscolaridade escolaridade;

    @Column(name="GENERO", nullable=true, columnDefinition = "varchar(30) default 'NAO_INFORMADO'")
    @Enumerated(EnumType.STRING)
    private EnumGenero genero;

    @Column(name="CATEGORIA", nullable=true, columnDefinition = "varchar(30) default 'NAO_INFORMADO'")
    @Enumerated(EnumType.STRING)
    private EnumCategoria categoria;

    @Column(name="RACA_COR", nullable=true, columnDefinition = "varchar(30) default 'NAO_INFORMADO'")
    @Enumerated(EnumType.STRING)
    private EnumRaca raca;

}
