package com.jp.agrodata.jpagrodata.models.entities;

import com.jp.agrodata.jpagrodata.models.embeddeds.Auditable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "TAB_ATENDIMENTO")
public class Atendimento extends Auditable implements Serializable {
    @Id
    @Column(name="ID", nullable=false, length=6)
    private String id;

    @Column(name = "LOCAL_T250", length = 250, unique = false, nullable = false)
    private String local;

    @ManyToOne
    @JoinColumn(name = "FUNCIONARIO_RESP_ID")
    private Usuario funcionario;

    @OneToMany
    @JoinColumn(name = "BENEF_ID")
    private List<Beneficiario> beneficiarios;

    @OneToOne
    @JoinColumn(name = "RELATORIO_ID")
    private Relatorio relatorio;

}
