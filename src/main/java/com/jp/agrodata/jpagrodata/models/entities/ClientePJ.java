package com.jp.agrodata.jpagrodata.models.entities;

import com.jp.agrodata.jpagrodata.models.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TAB_CLIENTE_PJ")
public class ClientePJ extends Pessoa {
    private String cnpj;
}
