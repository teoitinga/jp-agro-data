package com.jp.agrodata.jpagrodata.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TAB_CLAUSULA")
public class Clausula  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @Column(name="NUMERO", nullable=false)
    private Integer numero;

    @Column(name="DESCRIPTION", nullable=false)
    @Lob
    private String description;

    @ManyToOne
    @JoinColumn(name = "CONTRATO_COD")
    private Contrato contrato;
}
