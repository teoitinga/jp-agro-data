package com.jp.agrodata.jpagrodata.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "TAB_CONTA_BANCARIA")
public class ContaBancaria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "COD_AGENCIA")
    private AgenciaBancaria agencia;

    @ManyToOne
    @JoinColumn(name = "COD_EMPRESA")
    private Empresa empresa;

    @Column(unique = true, length = 10)
    private String numConta;
}
