package com.jp.agrodata.jpagrodata.models.embeddeds;

import com.jp.agrodata.jpagrodata.models.entities.Municipio;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Contato implements Serializable {

    @Column(name="EMAIL_T50", length = 50, nullable=true, unique = false)
    protected String email;

    @Column(name="ENDERECO_T100", length = 100, nullable=true, unique = false)
    protected String endereco;

    @Column(name="ZAP_T12", length = 12, nullable=true, unique = false)
    protected String whatsapp;

    @Column(name="FONE_T12", length = 12, nullable=true, unique = false)
    protected String foneContato;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "municipio_cod")
    private Municipio municipio;
}
