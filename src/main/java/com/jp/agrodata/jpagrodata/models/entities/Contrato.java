package com.jp.agrodata.jpagrodata.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    @Column(name = "CLAUSULAS_TL", nullable = false)
    @Lob
    private String clausulas;

    @Column(name = "OBJETO_TL", nullable = false)
    @Lob
    private String objeto;

    @Column(name = "SERVICOS_TL", nullable = false)
    @Lob
    private String servicos;

    @Column(name = "REMUNERACAO_TL", nullable = false)
    @Lob
    private String remuneracao;

    @Column(name = "DATA_CONTRATO_D")
    private LocalDateTime dataContrato;

    @Column(name = "CREATED_DATA_D")
    private LocalDateTime created;

    @Column(name = "FIM_VIGENCIA_CONTRATO_D")
    private LocalDateTime fimVigencia;

    @OneToOne(mappedBy = "contrato")
    private Empresa contratante;

    @Column(name = "VALOR_MENSAL", precision = 6, scale = 2)
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "COD_ROOT")
    private Root contratado;

    @PrePersist
    public void fechaContrato(){
        this.created = LocalDateTime.now();
    }
}
