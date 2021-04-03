package com.jp.agrodata.jpagrodata.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "TAB_CONTRATO")
public class Contrato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "OBJETO_TL", nullable = false)
    @Lob
    private String objeto;

    @Column(name = "SERVICOS_TL", nullable = false)
    @Lob
    private String servicos;

    @Column(name = "DATA_CONTRATO_D")
    private LocalDateTime dataContrato;

    @Column(name = "CREATED_DATA")
    private LocalDateTime created;

    @OneToOne(mappedBy = "contrato")
    private Empresa contratante;

    @ManyToOne
    @JoinColumn(name = "COD_ROOT")
    private Root contratado;

    @OneToMany(mappedBy = "contrato")
    private List<Clausula> clausulas;

    @ManyToOne
    @JoinColumn(name = "COD_PLANO")
    private Plano plano;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "municipio_cod")
    private Municipio local;

    @PrePersist
    public void fechaContrato(){
        this.created = LocalDateTime.now();
    }
}
