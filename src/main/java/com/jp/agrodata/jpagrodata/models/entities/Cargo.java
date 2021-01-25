package com.jp.agrodata.jpagrodata.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "TAB_CARGO")
public class Cargo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="CARGO", nullable=false, length=30)
    private String nomeDoCargo;

    @Column(name="CARGO_DESCRICAO", nullable=false, length=50)
    private String descricaoDoCargo;

    @Column(name="SALARIO", nullable=false, precision = 8, scale = 2)
    private BigDecimal salarioBase;

    @Column(name="HORAS_TRABALHADAS", nullable=false)
    private Integer horasTrabalhadas;

    @ManyToOne
    @JoinColumn(name = "cod_empresa_vinculada")
    private Empresa empresaVinculada;
}
