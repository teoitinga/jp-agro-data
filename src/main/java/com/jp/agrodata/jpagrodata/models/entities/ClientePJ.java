package com.jp.agrodata.jpagrodata.models.entities;

import com.jp.agrodata.jpagrodata.embeddeds.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@DiscriminatorValue("PESSOA_JURIDICA")
public class ClientePJ extends Pessoa {

    @Column(name="CNPJ_T20", nullable=false, length=20)
    private String cnpj;
}
