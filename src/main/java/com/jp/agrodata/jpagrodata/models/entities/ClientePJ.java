package com.jp.agrodata.jpagrodata.models.entities;

import com.jp.agrodata.jpagrodata.models.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
//@Table(name = "TAB_CLIENTE_PJ")
@DiscriminatorValue("PESSOA_JURIDICA")
public class ClientePJ extends Pessoa {
    private String cnpj;
}
